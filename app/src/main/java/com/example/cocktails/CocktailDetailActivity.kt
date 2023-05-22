package com.example.cocktails

import Cocktails
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CocktailDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_COCKTAIL = "cocktail"
        const val EXTRA_COCKTAIL_ID = "cocktailId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail_detail)

        // Set the toolbar as the activity's app bar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // Display cocktail information
        val cocktailId = intent?.extras?.getInt(EXTRA_COCKTAIL_ID, -1)
        if (cocktailId != null && cocktailId != -1) {
            var cocktails: List<Cocktail>
            if (intent?.extras?.getBoolean(EXTRA_COCKTAIL, true) == true)
            {
                cocktails = Cocktails(this).getCocktailList()
            }
            else
            {
                cocktails = Cocktails(this).getMocktailList()
            }
            val cocktailName = cocktails[cocktailId].getName()
            val cocktailRecipe = cocktails[cocktailId].getRecipe()
            val textView: TextView = findViewById(R.id.cocktail_text)
            textView.text = cocktailRecipe

            title = cocktailName

            val cocktailImage = cocktails[cocktailId].getImg()
            val imageView: ImageView = findViewById(R.id.cocktail_image)
            imageView.setImageDrawable(ContextCompat.getDrawable(this, cocktailImage))
            imageView.contentDescription = cocktailName
        }

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            // Open Gmail with predefined subject and body
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")

                if (cocktailId != null && cocktailId != -1) {
                    var cocktails: List<Cocktail>
                    if (intent?.extras?.getBoolean(EXTRA_COCKTAIL, true) == true)
                    {
                        cocktails = Cocktails(this@CocktailDetailActivity).getCocktailList()
                    }
                    else
                    {
                        cocktails = Cocktails(this@CocktailDetailActivity).getMocktailList()
                    }
                    val cocktailName = cocktails[cocktailId].getName()
                    val cocktailRecipe = cocktails[cocktailId].getRecipe()

                    putExtra(Intent.EXTRA_SUBJECT, cocktailName)
                    putExtra(Intent.EXTRA_TEXT, cocktailRecipe)
                }
            }
            startActivity(Intent.createChooser(emailIntent, "Send email"))
        }
    }



    override fun onSupportNavigateUp(): Boolean {
        // Handle the back button click on the toolbar
        finish()
        return true
    }
}
