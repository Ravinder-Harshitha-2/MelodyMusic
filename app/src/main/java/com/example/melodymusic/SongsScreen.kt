package com.example.melodymusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class SongsScreen : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var recyclerView: RecyclerView
    private lateinit var playlistAdapter: PlaylistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songs_screen)

        recyclerView = findViewById(R.id.playlistrecyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val playList = listOf(
            Playlist(R.drawable.thousandyears, "Thousand Years", ThousandYears::class.java),
            Playlist(R.drawable.supershy, "Super Shy", SuperShy::class.java),
            Playlist(R.drawable.yimmyyimmy, "Yimmy Yimmy", YimmyYimmy::class.java),
            Playlist(R.drawable.blindinglights, "Blinding Lights", BlindingLights::class.java),
            Playlist(R.drawable.mydad, "My Dad", MyDad::class.java),
            Playlist(R.drawable.chaleya, "Chaleya", Chaleya::class.java),
            Playlist(R.drawable.gangnamstyle, "Gangnam Style", GangnamStyle::class.java),
            Playlist(R.drawable.gulimata, "Guli Mata", GuliMata::class.java),
            Playlist(R.drawable.heeriye, "Heeriye", Heeriye::class.java),
            Playlist(R.drawable.staywithme, "Stay With Me", StayWithMe::class.java),
        )

        playlistAdapter = PlaylistAdapter(this, playList)
        recyclerView.adapter = playlistAdapter

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nav_view)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.icon_menu)
        }

        setupDrawer()
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