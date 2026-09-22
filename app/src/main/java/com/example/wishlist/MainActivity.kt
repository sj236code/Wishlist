package com.example.wishlist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private val wishlistItems = mutableListOf<WishlistItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val wishlistRecyclerView =
            findViewById<RecyclerView>(R.id.wishlistRecyclerView)

        val wishlistAdapter =
            WishlistAdapter(wishlistItems)

        val itemNameEditText =
            findViewById<EditText>(R.id.itemNameEditText)

        val itemPriceEditText =
            findViewById<EditText>(R.id.itemPriceEditText)

        val itemUrlEditText =
            findViewById<EditText>(R.id.itemUrlEditText)

        val submitButton =
            findViewById<Button>(R.id.submitButton)

        wishlistRecyclerView.adapter = wishlistAdapter
        wishlistRecyclerView.layoutManager = LinearLayoutManager(this)

        submitButton.setOnClickListener {

            val name = itemNameEditText.text.toString()
            val price = itemPriceEditText.text.toString()
            val url = itemUrlEditText.text.toString()

            if (name.isNotBlank() && price.isNotBlank() && url.isNotBlank()) {

                val newItem = WishlistItem(name, price, url)

                wishlistItems.add(newItem)

                wishlistAdapter.notifyItemInserted(wishlistItems.size - 1)

                itemNameEditText.text.clear()
                itemPriceEditText.text.clear()
                itemUrlEditText.text.clear()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
    }
}