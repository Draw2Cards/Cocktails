package com.example.cocktails
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class TopFragment : Fragment() {

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_top, container, false)
//    }
override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val rootView = inflater.inflate(R.layout.fragment_top, container, false)

    val cocktailRecycler: RecyclerView = rootView.findViewById(R.id.cocktailRecycler)
    //val layoutManager = LinearLayoutManager(requireContext())
    val layoutManager = GridLayoutManager(activity, 2)
    cocktailRecycler.layoutManager = layoutManager

    val cocktails = Cocktails()
    val adapter = CaptionedImagesAdapter(cocktails.getCocktailList())
    cocktailRecycler.adapter = adapter

    adapter.setListener(object : CaptionedImagesAdapter.Listener {
        override fun onClick(position: Int) {
            val intent = Intent(activity, CocktailDetailActivity::class.java)
            intent.putExtra(CocktailDetailActivity.EXTRA_COCKTAIL_ID, position)
            activity?.startActivity(intent)
        }
    })

    return rootView
}
}