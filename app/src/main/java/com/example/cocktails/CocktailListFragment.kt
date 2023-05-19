package com.example.cocktails

import android.R
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class CocktailListFragment : ListFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var list: ArrayList<Cocktail> = arrayListOf()

        var cocktails = Cocktails()
        cocktails.getCocktailList().forEach {
            list.add(it)
        }

        var adapter = ArrayAdapter(inflater.context, R.layout.simple_list_item_1, list)
        listAdapter = adapter

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private lateinit var listener: Listener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Listener
    }

    override fun onListItemClick(listView: ListView, itemView: View, position: Int, id: Long) {
        if (listener != null) {
            listener.itemClicked(id.toInt())
        }
    }

    interface Listener {
        fun itemClicked(id: Int)
    }
}