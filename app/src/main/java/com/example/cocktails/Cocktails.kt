import android.content.Context
import com.example.cocktails.Cocktail
import com.example.cocktails.R

class Cocktails {
    private val cocktailsList = arrayListOf<Cocktail>()
    private val mocktailsList = arrayListOf<Cocktail>()
    constructor(context: Context) {
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
                R.drawable.liit
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

    fun getMocktailById(id: Int): Cocktail {
        return mocktailsList[id]
    }

    fun getMocktailList(): List<Cocktail> {
        return mocktailsList
    }
}
   
