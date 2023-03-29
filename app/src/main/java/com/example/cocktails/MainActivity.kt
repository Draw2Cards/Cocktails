package com.example.cocktails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction

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

        val fragmentContainer : View = findViewById(R.id.fragment_container)
        if (fragmentContainer != null) {
            val details : JoggingDetailFragment = JoggingDetailFragment()
            val ft : FragmentTransaction = supportFragmentManager.beginTransaction()
            details.setCocktail(id)
            ft.replace(R.id.fragment_container, details)
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ft.addToBackStack(null)
            ft.commit()
        }
        else {
            val intent = Intent(this, DetailActivity::class.java);
            intent.putExtra(DetailActivity.EXTRA_COCKTAIL_ID, id)
            startActivity(intent)
        }
    }
}