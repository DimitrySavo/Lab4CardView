package com.example.lab4cardview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val countries = listOf(
            Country("Russia", R.drawable.ru, Random.nextInt(9000000,100000000)),
            Country("Vietnam", R.drawable.vn, Random.nextInt(9000000,100000000)),
            Country("USA", R.drawable.us, Random.nextInt(9000000,100000000)),
            Country("Japan", R.drawable.jp, Random.nextInt(9000000,100000000)),
            Country("Australia", R.drawable.au, Random.nextInt(9000000,100000000))
        )

        val rv: RecyclerView = findViewById(R.id.rvCountries)
        rv.adapter = CountryAdapter(countries){ country ->
            Toast.makeText(this, "Clicked on ${country.countryName}", Toast.LENGTH_SHORT).show()
        }
        rv.layoutManager = LinearLayoutManager(this)
    }


}