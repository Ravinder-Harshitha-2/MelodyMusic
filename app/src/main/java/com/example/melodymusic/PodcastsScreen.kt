package com.example.melodymusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class PodcastsScreen : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var recyclerView: RecyclerView
    private lateinit var podcastAdapter: PodcastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_podcasts_screen)

        recyclerView = findViewById(R.id.newpodcasts)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val podcastList = listOf(
            Podcast(R.drawable.kowabana, "Kowabana", Kowabana::class.java),
            Podcast(R.drawable.finshotsdaily, "Finshots Daily", FinshotsDaily::class.java),
            Podcast(R.drawable.theranveershow, "The Ranveer Show", TheRanveerShow::class.java),
            Podcast(R.drawable.indianbusinesspodcast, "Indian Business Podcast", IndianBusinessPodcast::class.java),
            Podcast(R.drawable.mrballen, "Mr Ballen Podcast", MrBallen::class.java),
            Podcast(R.drawable.southerncannibal, "Southern Cannibal", SouthernCannibal::class.java),
        )

        podcastAdapter = PodcastAdapter(this, podcastList)
        recyclerView.adapter = podcastAdapter

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nav_view)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.icon_menu) // Set your menu icon here
        }

        setupDrawer()

        val imageView1: ImageView = findViewById(R.id.indianbusinesspodcast)
        val imageView2: ImageView = findViewById(R.id.theranveershow)
        val imageView3: ImageView = findViewById(R.id.mrballen)
        val imageView4: ImageView = findViewById(R.id.joeroganexperience)
        val imageView5: ImageView = findViewById(R.id.letsread)

        val imageView6: ImageView = findViewById(R.id.kowabana)
        val imageView7: ImageView = findViewById(R.id.finshotsdaily)
        val imageView8: ImageView = findViewById(R.id.anipodcast)
        val imageView9: ImageView = findViewById(R.id.hauntingtube)
        val imageView10: ImageView = findViewById(R.id.southerncannibal)

        imageView1.setOnClickListener {
            val intent = Intent(this, IndianBusinessPodcast::class.java)
            startActivity(intent)
        }

        imageView2.setOnClickListener {
            val intent = Intent(this, TheRanveerShow::class.java)
            startActivity(intent)
        }

        imageView3.setOnClickListener {
            val intent = Intent(this, MrBallen::class.java)
            startActivity(intent)
        }

        imageView4.setOnClickListener {
            val intent = Intent(this, JoeRoganExperience::class.java)
            startActivity(intent)
        }

        imageView5.setOnClickListener {
            val intent = Intent(this, LetsRead::class.java)
            startActivity(intent)
        }

        imageView6.setOnClickListener {
            val intent = Intent(this, Kowabana::class.java)
            startActivity(intent)
        }

        imageView7.setOnClickListener {
            val intent = Intent(this, FinshotsDaily::class.java)
            startActivity(intent)
        }

        imageView8.setOnClickListener {
            val intent = Intent(this, AniPodcast::class.java)
            startActivity(intent)
        }

        imageView9.setOnClickListener {
            val intent = Intent(this, HauntingTube::class.java)
            startActivity(intent)
        }

        imageView10.setOnClickListener {
            val intent = Intent(this, SouthernCannibal::class.java)
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
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item clicks here
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Start HomeActivity
                    startActivity(Intent(this, HomeScreen::class.java))
                }

                R.id.nav_songs -> {
                    // Start GalleryActivity
                    startActivity(Intent(this, SongsScreen::class.java))
                }

                R.id.nav_podcasts -> {
                    // Start SettingsActivity
                    startActivity(Intent(this, PodcastsScreen::class.java))
                }

                R.id.nav_musicvideos -> {
                    // Start SettingsActivity
                    startActivity(Intent(this, MusicVideosScreen::class.java))
                }

                R.id.nav_information -> {
                    // Start SettingsActivity
                    startActivity(Intent(this, InformationScreen::class.java))
                }
            }
            // Close the drawer after handling click
            drawerLayout.closeDrawers()
            true
        }
    }
}