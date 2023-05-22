package com.example.cocktails

import android.content.Context

class Cocktails(context: Context) {
    private val cocktailsList = arrayListOf<Cocktail>()
    private val mocktailsList = arrayListOf<Cocktail>()

    init {
        val resources = context.resources
        cocktailsList.add(
            Cocktail(
                resources.getString(R.string.bloody_mary_recipe_title),
                resources.getString(R.string.bloody_mary_recipe),
                R.drawable.bm
            )
        )
        cocktailsList.add(
            Cocktail(
                resources.getString(R.string.long_island_iced_tea_recipe_title),
                resources.getString(R.string.long_island_iced_tea_recipe),
                R.drawable.long_island_ice_tea
            )
        )
        mocktailsList.add(
            Cocktail(
                resources.getString(R.string.virgin_mojito_title),
                resources.getString(R.string.virgin_mojito_recipe),
                R.drawable.m,
            )
        )
        mocktailsList.add(
            Cocktail(
                resources.getString(R.string.cocktail_virgin_pina_colada_title),
                resources.getString(R.string.cocktail_virgin_pina_colada_recipe),
                R.drawable.pc,
            )
        )
    }

    fun getCocktailById(id: Int): Cocktail {
        return cocktailsList[id]
    }

    fun getCocktailList(): List<Cocktail> {
        return cocktailsList
    }

    fun getMocktailList(): List<Cocktail> {
        return mocktailsList
    }
}
   
