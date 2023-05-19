package com.example.cocktails
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class TopFragment : Fragment() {

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_top, container, false)
//    }
override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val rootView = inflater.inflate(R.layout.fragment_top, container, false)

    val cocktailRecycler: RecyclerView = rootView.findViewById(R.id.cocktailRecycler)
    val layoutManager = LinearLayoutManager(requireContext())
    cocktailRecycler.layoutManager = layoutManager

    val cocktails = Cocktails()
    val adapter = CaptionedImagesAdapter(cocktails.getCocktailList())
    cocktailRecycler.adapter = adapter

    return rootView
}

}