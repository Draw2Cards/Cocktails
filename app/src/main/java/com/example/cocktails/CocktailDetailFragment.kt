package com.example.cocktails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.TextView

class CocktailDetailFragment : Fragment(R.layout.fragment_cocktail_detail) {
    private var cocktailId: Long = -1

    override fun onStart() {
        super.onStart()
        if (view != null) {
            val title: TextView = requireView().findViewById(R.id.textTitle)
            val cocktails = Cocktails(requireContext())
            val cocktail: Cocktail = cocktails.getCocktailById(cocktailId.toInt())
            title.text = cocktail.getName()
            val desc: TextView = requireView().findViewById(R.id.textDescription)
            desc.text = cocktail.getRecipe()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("cocktailId", cocktailId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState != null) {
            cocktailId = savedInstanceState.getLong("cocktailId")
        }
    }


}
