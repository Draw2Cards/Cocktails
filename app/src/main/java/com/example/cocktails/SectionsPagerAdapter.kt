import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cocktails.MocktailsFragment
import com.example.cocktails.CocktailsFragment

class SectionsPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> CocktailsFragment()
            2 -> MocktailsFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

}


