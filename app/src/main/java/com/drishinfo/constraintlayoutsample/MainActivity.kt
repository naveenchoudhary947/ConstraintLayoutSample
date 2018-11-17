package com.drishinfo.constraintlayoutsample

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.*
import android.widget.TextView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        findViewById<RecyclerView>(R.id.recyclerView).let {
            it.setHasFixedSize(true)
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = CustomAdapter(getData(), this)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun getData(): ArrayList<Contact> {
        val arrayList: ArrayList<Contact> = ArrayList()
        val gson = Gson()
        val json = Constant.JSON
        val contactResponse = gson.fromJson(json, ContactsResponse::class.java)
        arrayList.addAll(contactResponse.Contacts)
        return arrayList
    }

    class CustomAdapter(private val arrayList: ArrayList<Contact>, private val context: Context) :
        RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomAdapter.ViewHolder {
            return CustomAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_contact, p0, false))
        }

        override fun getItemCount(): Int {
            return arrayList.size
        }

        override fun onBindViewHolder(p0: CustomAdapter.ViewHolder, p1: Int) {
            val contact = arrayList[p1]
            when {
                TextUtils.isEmpty(contact.Name) -> p0.nameText.visibility = View.GONE
                else -> {
                    p0.nameText.text = contact.Name
                    p0.nameText.visibility = View.VISIBLE
                }
            }
            when {
                TextUtils.isEmpty( contact.Desc) -> p0.descText.visibility = View.GONE
                else -> {
                    p0.descText.text =  contact.Desc
                    p0.descText.visibility = View.VISIBLE
                }
            }

            when {
                TextUtils.isEmpty(contact.Date) -> p0.dateText.visibility = View.GONE
                else -> {
                    p0.dateText.text = contact.Date
                    p0.dateText.visibility = View.VISIBLE
                }
            }

            when {
                TextUtils.isEmpty(contact.Email) -> p0.emailText.visibility = View.GONE
                else -> {
                    p0.emailText.text = contact.Email
                    p0.emailText.visibility = View.VISIBLE
                }
            }

            when {
                TextUtils.isEmpty(contact.Category) -> p0.catText.visibility = View.GONE
                else -> {
                    p0.catText.text = contact.Category
                    p0.catText.visibility = View.VISIBLE
                }
            }
        }

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nameText: TextView = itemView.findViewById(R.id.nameText)
            val descText: TextView = itemView.findViewById(R.id.descText)
            val dateText: TextView = itemView.findViewById(R.id.dateText)
            val emailText: TextView = itemView.findViewById(R.id.emailText)
            val catText: TextView = itemView.findViewById(R.id.catText)

        }
    }
}
