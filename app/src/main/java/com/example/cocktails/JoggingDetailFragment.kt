package com.example.cocktails

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.floatingactionbutton.FloatingActionButton

class JoggingDetailFragment : Fragment(R.layout.fragment_jogging_detail), View.OnClickListener {
    private var joggingId: Long = -1

    fun setCocktail(id: Int) {
        joggingId = id.toLong()
    }

    override fun onStart() {
        super.onStart()
        if (view != null) {
            val title: TextView = requireView().findViewById(R.id.textTitle)
            val cocktails = Cocktails(requireContext())
            val cocktail: Cocktail = cocktails.getCocktailById(joggingId.toInt())
            title.text = cocktail.getName()
            val desc: TextView = requireView().findViewById(R.id.textDescription)
            desc.text = cocktail.getRecipe()
            val fab: FloatingActionButton = requireView().findViewById(R.id.fab)
            fab.setOnClickListener(this)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("joggingId", joggingId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val stopper = StopperFragment()
            val ft = childFragmentManager.beginTransaction()
            ft.add(R.id.stopper_container, stopper)
            ft.addToBackStack(null)
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ft.commit()
        } else {
            joggingId = savedInstanceState.getLong("joggingId")
        }
    }

    override fun onClick(v: View?) {
        val cocktails = Cocktails(requireContext())
        val cocktail: Cocktail = cocktails.getCocktailById(joggingId.toInt())
        when (v?.id)
        {
            R.id.fab -> shareRecipe(cocktail.getName(),cocktail.getRecipe())
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun shareRecipe(title: String, recipe: String) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, title)
        shareIntent.putExtra(Intent.EXTRA_TEXT, recipe)

        val packageManager: PackageManager = requireActivity().packageManager
        val activities: List<ResolveInfo> = packageManager.queryIntentActivities(shareIntent, 0)
        val isEmailAppAvailable = activities.any { it.activityInfo.packageName.contains("com.google.android.gm") }

        if (isEmailAppAvailable) {
            shareIntent.setPackage("com.google.android.gm") // Set the package name of Gmail
            startActivity(shareIntent)
        } else {
            Toast.makeText(requireContext(), "Email app not found", Toast.LENGTH_SHORT).show()
        }
    }



}
