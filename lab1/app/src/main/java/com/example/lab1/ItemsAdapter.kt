
package com.example.lab1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ItemsAdapter(var items: List<Item>, var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val ITEM_TYPE_ITEM = 0
    private val ITEM_TYPE_NEW_ITEM = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_TYPE_ITEM -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
                MyViewHolder(view)
            }
            ITEM_TYPE_NEW_ITEM -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.new_item, parent, false)
                MyViewHolder2(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        return if (item.flag) {
            ITEM_TYPE_NEW_ITEM
        } else {
            ITEM_TYPE_ITEM
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHolder) {
            val currentItem = items[position]
            holder.title.text = currentItem.title
            holder.button.text = currentItem.button
            val imageId = context.resources.getIdentifier(
                currentItem.image,
                "drawable",
                context.packageName
            )
            holder.image.setImageResource(imageId)
            holder.btn.setOnClickListener {
                val intent = Intent(context, ItemActivity::class.java)
                intent.putExtra("itemImage", currentItem.image)
                intent.putExtra("itemTitle", currentItem.title)
                intent.putExtra("itemText", currentItem.desc)
                intent.putExtra("itemButton", currentItem.button)
                context.startActivity(intent)
            }
        } else if (holder is MyViewHolder2) {
            val currentNewItem = items[position]
            holder.title2.text = currentNewItem.title
            holder.desc2.text = currentNewItem.desc
            holder.button2.text = currentNewItem.button
            val imageId = context.resources.getIdentifier(
                currentNewItem.image,
                "drawable",
                context.packageName
            )
            holder.image2.setImageResource(imageId)
            holder.btn2.setOnClickListener {
                val intent = Intent(context, ItemActivity::class.java)
                intent.putExtra("itemImage", currentNewItem.image)
                intent.putExtra("itemTitle", currentNewItem.title)
                intent.putExtra("itemText", currentNewItem.desc)
                intent.putExtra("itemButton", currentNewItem.button)
                context.startActivity(intent)
            }
        }
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.item_list_image)
        val title: TextView = view.findViewById(R.id.item_list_title)
        val button: TextView = view.findViewById(R.id.item_list_button)
        val btn: Button = view.findViewById(R.id.item_list_button)
    }
    class MyViewHolder2(view: View) : RecyclerView.ViewHolder(view) {
        val image2: ImageView = view.findViewById(R.id.npizza)
        val title2: TextView = view.findViewById(R.id.nname)
        val desc2: TextView = view.findViewById(R.id.nsmalldescription)
        val button2: TextView = view.findViewById(R.id.nprice)
        val btn2: Button = view.findViewById(R.id.nprice)
    }
}