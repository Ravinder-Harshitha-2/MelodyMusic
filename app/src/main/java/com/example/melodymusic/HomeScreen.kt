package com.example.melodymusic

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class HomeScreen : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var recyclerView: RecyclerView
    private lateinit var songAdapter: SongAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        textView = findViewById(R.id.textView)

        // Shared preferences
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val text = sharedPreferences.getString("text", "")
        textView.text = "Welcome $text !"

        recyclerView = findViewById(R.id.newsongs)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // list to display songs
        val songList = listOf(
            Songs(R.drawable.mydad, "My Dad", MyDad::class.java),
            Songs(R.drawable.blindinglights, "Blinding Lights", BlindingLights::class.java),
            Songs(R.drawable.thousandyears, "Thousand Years", ThousandYears::class.java),
            Songs(R.drawable.supershy, "Super Shy", SuperShy::class.java),
            Songs(R.drawable.yimmyyimmy, "Yimmy Yimmy", YimmyYimmy::class.java),
            Songs(R.drawable.chaleya, "Chaleya", Chaleya::class.java),
        )

        // Adapter
        songAdapter = SongAdapter(this, songList)
        recyclerView.adapter = songAdapter

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nav_view)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.icon_menu)
        }

        setupDrawer()

        // function to display images and intents to take them to corresponding activity
        val imageView1: ImageView = findViewById(R.id.chaleya)
        val imageView2: ImageView = findViewById(R.id.blindinglights)
        val imageView3: ImageView = findViewById(R.id.thousandyears)
        val imageView4: ImageView = findViewById(R.id.gangnamstyle)
        val imageView5: ImageView = findViewById(R.id.staywithme)

        val imageView6: ImageView = findViewById(R.id.gulimata)
        val imageView7: ImageView = findViewById(R.id.mydad)
        val imageView8: ImageView = findViewById(R.id.supershy)
        val imageView9: ImageView = findViewById(R.id.yimmyyimmy)
        val imageView10: ImageView = findViewById(R.id.heeriye)

        imageView1.setOnClickListener {
            val intent = Intent(this, Chaleya::class.java)
            startActivity(intent)
        }

        imageView2.setOnClickListener {
            val intent = Intent(this, BlindingLights::class.java)
            startActivity(intent)
        }

        imageView3.setOnClickListener {
            val intent = Intent(this, ThousandYears::class.java)
            startActivity(intent)
        }

        imageView4.setOnClickListener {
            val intent = Intent(this, GangnamStyle::class.java)
            startActivity(intent)
        }

        imageView5.setOnClickListener {
            val intent = Intent(this, StayWithMe::class.java)
            startActivity(intent)
        }

        imageView6.setOnClickListener {
            val intent = Intent(this, GuliMata::class.java)
            startActivity(intent)
        }

        imageView7.setOnClickListener {
            val intent = Intent(this, MyDad::class.java)
            startActivity(intent)
        }

        imageView8.setOnClickListener {
            val intent = Intent(this, SuperShy::class.java)
            startActivity(intent)
        }

        imageView9.setOnClickListener {
            val intent = Intent(this, YimmyYimmy::class.java)
            startActivity(intent)
        }

        imageView10.setOnClickListener {
            val intent = Intent(this, Heeriye::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Open/close the navigation drawer when the navigation icon is clicked
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    drawerLayout.openDrawer(GravityCompat.START)
                }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupDrawer() {
        // Navigation enabled with intents
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomeScreen::class.java))
                }

                R.id.nav_songs -> {
                    startActivity(Intent(this, SongsScreen::class.java))
                }

                R.id.nav_podcasts -> {
                    startActivity(Intent(this, PodcastsScreen::class.java))
                }

                R.id.nav_musicvideos -> {
                    startActivity(Intent(this, MusicVideosScreen::class.java))
                }

                R.id.nav_information -> {
                    startActivity(Intent(this, InformationScreen::class.java))
                }
            }

            drawerLayout.closeDrawers()
            true
        }
    }
}