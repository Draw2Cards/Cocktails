package com.example.cocktails

class Cocktail {
    private var name: String = ""
    private var recipte: String = ""
    private var img: Int = -1

    constructor(name: String, recipte: String, img: Int) {
        this.name = name
        this.recipte = recipte
        this.img = img
    }

    fun getName(): String {return name}
    fun getRecipte(): String {return recipte}

    fun getImg(): Int {return img}
    override fun toString(): String {return name}
}