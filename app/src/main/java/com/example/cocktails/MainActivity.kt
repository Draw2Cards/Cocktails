package com.example.cocktails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity(), CocktailListFragment.Listener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//    fun onShowDetail(view: View) {
//        val intent = Intent(this, DetailActivity::class.java);
//        startActivity(intent)
//    }

    override fun itemClicked(id: Long) {
        val intent = Intent(this, DetailActivity::class.java);
        intent.putExtra(DetailActivity.EXTRA_COCKTAIL_ID, id)
        startActivity(intent)
    }
}