package com.example.lab1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.EditText
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var itemsAdapter: ItemsAdapter
    private val allItems = arrayListOf<Item>()
    private val filteredItems = arrayListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchEditText = findViewById(R.id.searchEditText)
        searchButton = findViewById(R.id.searchButton)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        itemsAdapter = ItemsAdapter(allItems, this)
        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = itemsAdapter

        allItems.addAll(getAllItems())

        searchButton.setOnClickListener {
            val query = searchEditText.text.toString().trim()
            filterItems(query)
        }
    }

    private fun getAllItems(): List<Item> {
        val items = arrayListOf<Item>()

        items.add(Item(1,"wowkebab", "Wow! Kebab", "Beef kebab, ranch sauce, mozarella cheese, sweet pepper, tomatoes, red onion, marinara sauce","2900 тг", false))
        items.add(Item(2,"withmushrooms", "Pepperoni with mushrooms", "Chicken pepperoni, mozarella cheese, mushrooms, alfredo sauce","2000 тг", false))
        items.add(Item(3,"hampickes", "Ham&Pickles", "Ranch sauce, chicken ham, mozarella cheese, pickles, red onion","2000 тг", false))
        items.add(Item(4, "combo1", "KikoRiki Combo", "Approved by cartoon characters: small pizza of any flavor and young gardener's kit Combo price depends on the selected pizzas and may change.", "2300 тг", true))
        items.add(Item(5,"cheesy", "Cheesy", "Mozzarella cheese, cheddar cheese, parmesan cheese, Alfredo sauce","1900 тг", false))
        items.add(Item(6,"pepperonifresh", "Pepperoni Fresh", "Chicken pepperoni, extra mozzarella cheese, tomatoes, marinara sauce","1900 тг", false))
        items.add(Item(7,"doublecincken", "Double Chicken", "Double chicken, mozzarella cheese, Alfredo sauce","2900 тг", false))
        items.add(Item(8, "comb04", "Bavarian combo", "Spicy chorizo sausages, pickled cucumbers, red onions, tomatoes, mustard sauce, mozzarella, signature tomato sauce", "1600 тг", true))
        items.add(Item(9,"chorizo", "Chorizo fresh", "Spicy chorizo, sweet pepper, mozzarella cheese, marinara sauce","1900 тг", false))
        items.add(Item(10,"hamcheese", "Ham & Cheese", "Chicken ham, mozzarella cheese, Alfredo sauce","1900 тг", false))
        items.add(Item(11,"carbonara", "Carbonara", "Chicken ham, cheddar cheese, parmesan cheese, tomatoes, red onion, mozzarella cheese, Alfredo sauce, garlic, Italian seasoning","2400 тг", false))
        items.add(Item(12,"chessychicken", "Cheesy chicken", "Chicken, mozzarella cheese, cheddar cheese, parmesan cheese, cheese sauce, tomatoes, Alfredo sauce, garlic","2900 тг", false))
        return items
    }
    private fun filterItems(query: String) {
        filteredItems.clear()

        if (query.isEmpty()) {
            filteredItems.addAll(allItems)
        } else {
            for (item in allItems) {
                if (item.title.contains(query, ignoreCase = true) || item.desc.contains(query, ignoreCase = true)) {
                    filteredItems.add(item)
                }
            }
        }

        itemsAdapter.items = filteredItems
        itemsAdapter.notifyDataSetChanged()
    }
}