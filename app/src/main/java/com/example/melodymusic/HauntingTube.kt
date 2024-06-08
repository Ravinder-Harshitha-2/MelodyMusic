package com.example.melodymusic

import android.content.Intent
import android.graphics.PorterDuff
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import java.util.Locale

class HauntingTube : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var playPrevButton: ImageView
    private lateinit var playNextButton: ImageView
    private lateinit var pauseButton: ImageView
    private lateinit var backButton: ImageView
    private lateinit var seekBar: SeekBar
    private lateinit var textViewStartTime: TextView
    private lateinit var textViewEndTime: TextView
    private lateinit var handler: Handler
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_haunting_tube)

        playPrevButton = findViewById(R.id.playprevButton)
        playNextButton = findViewById(R.id.playnextButton)
        pauseButton = findViewById(R.id.pauseButton)
        backButton = findViewById(R.id.backButton)
        seekBar = findViewById(R.id.seekbar)
        textViewStartTime = findViewById(R.id.textViewStartTime)
        textViewEndTime = findViewById(R.id.textViewEndTime)
        handler = Handler()

        mediaPlayer = MediaPlayer.create(this,R.raw.hauntingtube)
        seekBar.max = mediaPlayer.duration
        textViewEndTime.text = formatTime(mediaPlayer.duration)
        seekBar.progressDrawable.setColorFilter(resources.getColor(R.color.white), PorterDuff.Mode.SRC_IN)
        seekBar.thumb.setColorFilter(resources.getColor(R.color.white), PorterDuff.Mode.SRC_IN)

        if (mediaPlayer == null) {
            Toast.makeText(this, "Failed to initialize media player", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        playPrevButton.setOnClickListener {
            val intent = Intent(this, AniPodcast::class.java)
            startActivity(intent)
        }

        pauseButton.setOnClickListener {
            if (isPlaying) {
                mediaPlayer.pause()
                pauseButton.setImageResource(R.drawable.playbuttonpurple)
            }

            else {
                mediaPlayer.start()
                pauseButton.setImageResource(R.drawable.pausebuttonpurple)
            }
            isPlaying = !isPlaying
        }

        playNextButton.setOnClickListener {
            val intent = Intent(this, SouthernCannibal::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, PodcastsScreen::class.java)
            startActivity(intent)
        }

        mediaPlayer.setOnPreparedListener {
            mediaPlayer.start()
            updateSeekBarAndTime()
        }

        return
    }

    private fun updateSeekBarAndTime() {
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                val currentPosition = mediaPlayer.currentPosition
                seekBar.progress = currentPosition
                textViewStartTime.text = formatTime(currentPosition)
                handler.postDelayed(this, 1000) // Update every second
            }
        }, 0)
    }

    private fun formatTime(timeMs: Int): String {
        val minutes = java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(timeMs.toLong())
        val seconds = java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(timeMs.toLong()) % 60
        return String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}