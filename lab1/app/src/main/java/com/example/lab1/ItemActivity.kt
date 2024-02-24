
package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val image: ImageView = findViewById(R.id.item_list_image_2)
        val title: TextView = findViewById(R.id.item_list_title_one)
        val text: TextView = findViewById(R.id.item_list_text)
        val button: TextView = findViewById(R.id.button_buy)

        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
        button.text = intent.getStringExtra("itemButton")
        val imageName = intent.getStringExtra("itemImage")

        // Get the resource ID of the image dynamically
        val imageId = resources.getIdentifier(imageName, "drawable", packageName)

        // Set the image resource to the ImageView
        if (imageId != 0) {
            image.setImageResource(imageId)
        } else {
            // Set a default image if the resource is not found
            image.setImageResource(R.drawable.wowkebab)
        }

    }
}