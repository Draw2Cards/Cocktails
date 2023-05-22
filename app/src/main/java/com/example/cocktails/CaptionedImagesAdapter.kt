package com.example.cocktails

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CaptionedImagesAdapter(private val cocktails: List<Cocktail>) :
    RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>() {

    private var listener: Listener? = null

    interface Listener {
        fun onClick(position: Int)
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }


    inner class ViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_captioned_image, parent, false) as CardView
        return ViewHolder(cardView)
    }

    override fun getItemCount(): Int {
        return cocktails.size
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
            listener?.onClick(position)
        }
    }


    // Other methods and code for the adapter
}
