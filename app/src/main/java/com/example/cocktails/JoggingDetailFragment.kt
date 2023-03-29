package com.example.cocktails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction

class JoggingDetailFragment : Fragment(R.layout.fragment_jogging_detail) {
    private var joggingId: Long = -1

    fun setCocktail(id: Long) {
        joggingId = id.toLong()
    }

    override fun onStart() {
        super.onStart()
        if (view != null) {
            var title: TextView = requireView().findViewById(R.id.textTitle)
            var cocktails = Cocktails()
            var cocktail: Cocktail = cocktails.get(joggingId)
            title.text = cocktail.getName()
            var desc: TextView = requireView().findViewById(R.id.textDescription)
            desc.text = cocktail.getRecipte()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("joggingId", joggingId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val stoper = StoperFragment()
            val ft = childFragmentManager.beginTransaction()
            ft.add(R.id.stoper_container, stoper)
            ft.addToBackStack(null)
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ft.commit()
        } else {
            joggingId = savedInstanceState.getLong("joggingId")
        }
    }



}
