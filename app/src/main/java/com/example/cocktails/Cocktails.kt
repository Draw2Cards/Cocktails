package com.example.cocktails

class Cocktails {
    private val cocktailsList = arrayListOf<Cocktail>()

    constructor() {
        cocktailsList.add(Cocktail("Bloody Mary", "Składniki:\n40 ml wódki...", R.drawable.bm))
        cocktailsList.add(Cocktail("Long Island Iced Tea", "Ingredients:\n1 oz Gomme Syrup, 1 oz Lemon juice, 1/2 oz Gin...", R.drawable.liit))
    }
    fun getCocktailById(id: Int): Cocktail {return cocktailsList[id]
    }

    fun getCocktailList(): List<Cocktail> {return cocktailsList}
}