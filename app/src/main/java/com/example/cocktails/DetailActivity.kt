package com.example.cocktails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val frag: JoggingDetailFragment =
            supportFragmentManager.findFragmentById (R.id.detail_frag) as JoggingDetailFragment
        val cocktailId = intent.getLongExtra(EXTRA_COCKTAIL_ID, -1)
        frag.setCocktail(cocktailId.toInt())
    }

    companion object {
        const val EXTRA_COCKTAIL_ID: String = "id"
    }
}