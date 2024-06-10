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

class MusicVideosScreen : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var musicVideoAdapter: MusicVideoAdapter
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_videos_screen)

        recyclerView = findViewById(R.id.musicvideosrecyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // List of song names and youtube hyperlinks to view the videos
        val musicVideosList = listOf(
            MusicVideos(R.drawable.odimaga, "Odimaga", "https://youtu.be/xmVITsClKvw?si=HEnf4GYko0sn6Qzj"),
            MusicVideos(R.drawable.biba, "Biba Nachdi", "https://youtu.be/UhYRlI_bpJQ?si=kOQf7aWllJi4cugq"),
            MusicVideos(R.drawable.onthefloor, "Get On The Floor", "https://youtu.be/t4H_Zoh7G5A?si=0dUJioXzlHRzTJme"),
            MusicVideos(R.drawable.baby, "Baby", "https://youtu.be/kffacxfA7G4?si=-HvVYBIaotfxiELy"),
            MusicVideos(R.drawable.kalachashma, "Kala Chashma", "https://youtu.be/4WRJHbL4dAk?si=am0XKn8f3s_H9Nwv"),
            MusicVideos(R.drawable.believer, "Believer", "https://youtu.be/7wtfhZwyrcc?si=_ln7v5XUgutHFAQL"),
            MusicVideos(R.drawable.yimmyyimmy, "Yimmy Yimmy", "https://youtu.be/OzI9M74IfR0?si=go4rNaGD0UVopJPt"),
            MusicVideos(R.drawable.mydad, "1985", "https://youtu.be/7BwqflkkeEg?si=ApQItjrvlVEhS7Zy"),
            MusicVideos(R.drawable.supershy, "Super Shy", "https://youtu.be/ArmDp-zijuc?si=1-txevIJL2yT5Jeb"),
            MusicVideos(R.drawable.gangnamstyle, "Gangnam Style", "https://youtu.be/9bZkp7q19f0?si=VGzlGcgyDvAeUfjZ"),
            )

        // Adapter
        musicVideoAdapter = MusicVideoAdapter(this, musicVideosList)
        recyclerView.adapter = musicVideoAdapter

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

    // function to handle the open and close of navigation bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
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

    // function to handle the movement between activities using intents
    private fun setupDrawer() {
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