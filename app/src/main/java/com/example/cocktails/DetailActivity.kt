package com.example.cocktails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val frag: CocktailDetailFragment =
            supportFragmentManager.findFragmentById (R.id.detail_frag) as CocktailDetailFragment;
        var cocktailId = intent.getLongExtra(EXTRA_COCKTAIL_ID, -1);
        frag.setCocktail(cocktailId);
    }

    companion object {
        val EXTRA_COCKTAIL_ID: String = "id"
    }
}