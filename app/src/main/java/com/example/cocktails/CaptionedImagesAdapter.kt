package com.example.cocktails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView

class CaptionedImagesAdapter(private val cocktails: List<Cocktail>) :
    RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>() {

    interface Listener : CocktailListFragment.Listener {
        override fun itemClicked(id: Int)
    }

    private var listener: Listener? = null

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_captioned_image, parent, false) as CardView
        val viewHolder = ViewHolder(cardView)

        // Set the listener for the ViewHolder
        viewHolder.setListener(listener)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView = holder.cardView
        val imageView = cardView.findViewById<ImageView>(R.id.info_image)
        val drawable = ContextCompat.getDrawable(cardView.context, cocktails[position].getImg())
        imageView.setImageDrawable(drawable)
        imageView.contentDescription = cocktails[position].getName()
        val textView = cardView.findViewById<TextView>(R.id.info_text)
        textView.text = cocktails[position].getName()


        cardView.setOnClickListener {
            val context = cardView.context
            val details : JoggingDetailFragment = JoggingDetailFragment()
            val ft : FragmentManager = (context as AppCompatActivity).supportFragmentManager
            details.setCocktail(position)
            ft.beginTransaction().replace(R.id.fragment_container, details).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit()
        }

    }

    override fun getItemCount(): Int {
        return cocktails.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView as CardView
        private var listener: CocktailListFragment.Listener? = null

        init {
            cardView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // Call the itemClicked method in the listener
                    listener?.itemClicked(position)
                }
            }
        }

        fun setListener(listener: Listener?) {
            this.listener = listener
        }
    }


}