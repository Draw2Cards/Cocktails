package com.example.cocktails

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

    fun setCocktail(id: Long) {
        joggingId = id.toLong()
    }

    override fun onStart() {
        super.onStart()
        if (view != null) {
            var title: TextView = requireView().findViewById(R.id.textTitle)
            var cocktails = Cocktails()
            var cocktail: Cocktail = cocktails.get(joggingId)
            title.text = cocktail.getName()
            var desc: TextView = requireView().findViewById(R.id.textDescription)
            desc.text = cocktail.getRecipte()
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
            val stoper = StoperFragment()
            val ft = childFragmentManager.beginTransaction()
            ft.add(R.id.stoper_container, stoper)
            ft.addToBackStack(null)
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ft.commit()
        } else {
            joggingId = savedInstanceState.getLong("joggingId")
        }
    }

    override fun onClick(v: View?) {
        var cocktails = Cocktails()
        var cocktail: Cocktail = cocktails.get(joggingId)
        when (v?.id)
        {
            R.id.fab -> shareRecipe(cocktail.getName(),cocktail.getRecipte())
        }
    }

    private fun shareRecipe(title: String, recipe: String) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, title)
        shareIntent.putExtra(Intent.EXTRA_TEXT, recipe)

        // Check if there is an email app available to handle the share intent
        val packageManager: PackageManager = requireActivity().packageManager
        val activities: List<ResolveInfo> = packageManager.queryIntentActivities(shareIntent, 0)
        val isEmailAppAvailable = activities.any { it.activityInfo.packageName.contains("com.google.android.gm") }

        if (isEmailAppAvailable) {
            // Share the recipe using the email app
            shareIntent.setPackage("com.google.android.gm") // Set the package name of Gmail
            startActivity(shareIntent)
        } else {
            // If email app is not available, show a toast or handle the case as per your requirement
            Toast.makeText(requireContext(), "Email app not found", Toast.LENGTH_SHORT).show()
        }
    }



}
