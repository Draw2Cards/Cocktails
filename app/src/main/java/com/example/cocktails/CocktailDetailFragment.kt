package com.example.cocktails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.TextView

class CocktailDetailFragment : Fragment(R.layout.fragment_cocktail_detail) {
    private var cocktailId: Long = -1

    fun setCocktail(id: Long) {
        cocktailId = id.toLong()
    }

    override fun onStart() {
        super.onStart()
        if (view != null) {
            var title: TextView = requireView().findViewById(R.id.textTitle)
            var cocktails = Cocktails()
            var cocktail: Cocktail = cocktails.getCocktailById(cocktailId.toInt())
            title.text = cocktail.getName()
            var desc: TextView = requireView().findViewById(R.id.textDescription)
            desc.text = cocktail.getRecipte()
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
