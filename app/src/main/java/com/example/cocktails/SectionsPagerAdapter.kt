import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cocktails.Tab2Fragment
import com.example.cocktails.TopFragment

class SectionsPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TopFragment()
            1 -> Tab1Fragment()
            2 -> Tab2Fragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

}


