package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(
    private val wishlistItems: List<WishlistItem>
) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val itemNameTextView: TextView =
            view.findViewById(R.id.itemNameTextView)

        val itemPriceTextView: TextView =
            view.findViewById(R.id.itemPriceTextView)

        val itemUrlTextView: TextView =
            view.findViewById(R.id.itemUrlTextView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.wishlist_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val item = wishlistItems[position]

        holder.itemNameTextView.text = item.name
        holder.itemPriceTextView.text = "$${item.price}"
        holder.itemUrlTextView.text = item.url
    }

    override fun getItemCount(): Int {
        return wishlistItems.size
    }
}