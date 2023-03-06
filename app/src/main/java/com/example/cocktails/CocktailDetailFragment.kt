package com.example.cocktails

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
            var cocktail: Cocktail = cocktails.get(cocktailId)
            title.text = cocktail.getName()
            var desc: TextView = requireView().findViewById(R.id.textDescription)
            desc.text = cocktail.getRecipte()
        }
    }
}
