package com.example.cocktails

class Cocktail {
    private var name: String = ""
    private var recipte: String = ""

    constructor(name: String, recipte: String) {
        this.name = name
        this.recipte = recipte
    }

    fun getName(): String {return name}
    fun getRecipte(): String {return recipte}
    override fun toString(): String {return name}
}