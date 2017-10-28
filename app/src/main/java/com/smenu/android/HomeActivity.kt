package com.smenu.android

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var listView = findViewById<ListView>(R.id.list_view)
        listView.adapter = RestaurantListAdapater(this)
        listView.setOnItemClickListener {parent, view, position, id ->
            var intent = Intent(this, RestaurentHomeActivity::class.java)
            startActivity(intent)
        }
    }

    private class RestaurantListAdapater(context: Context) : BaseAdapter() {
        internal var sList = arrayOf("McDolond", "KFC", "FuLinMen")
        private val mInflator: LayoutInflater;

        init {
            this.mInflator = LayoutInflater.from(context)
        }

        override fun getCount(): Int {
            return sList.size
        }

        override fun getItem(position: Int): Any {
            return sList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var view: TextView
            view = this.mInflator.inflate(R.layout.restaurent_item,  parent,false) as TextView
            view.text = sList[position]
            return view
        }

    }
}
