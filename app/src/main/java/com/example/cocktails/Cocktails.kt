package com.example.cocktails

class Cocktails {
    private val cocktailsList = arrayListOf<Cocktail>()

    constructor() {
        cocktailsList.add(Cocktail("Bloody Mary", "Składniki:\n40 ml wódki..."))
        cocktailsList.add(Cocktail("Long Island Iced Tea", "Ingredients:\n1 oz Gomme Syrup, 1 oz Lemon juice, 1/2 oz Gin..."))
    }
    fun get(id: Long): Cocktail {return cocktailsList[id.toInt()]
    }

    fun getList(): ArrayList<Cocktail> {return cocktailsList}
}