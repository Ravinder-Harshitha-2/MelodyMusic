package com.example.melodymusic

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicVideoAdapter(val context: Context, private val musicVideosList: List<MusicVideos>): RecyclerView.Adapter<MusicVideoAdapter.MusicVideoViewHolder>() {

    inner class MusicVideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoImageView: ImageView = itemView.findViewById(R.id.videoImageView)
        val videoTitleTextView: TextView = itemView.findViewById(R.id.videoTitleTextView)
        val videoButton: Button = itemView.findViewById(R.id.videobutton)

        fun bind(musicVideos: MusicVideos) {
            videoImageView.setImageResource(musicVideos.videoimageResource)
            videoTitleTextView.text = musicVideos.videotitle
            videoButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(musicVideos.videohyperlink))
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicVideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.music_video_items, parent, false)
        return MusicVideoViewHolder(view)
    }


    override fun onBindViewHolder(holder: MusicVideoViewHolder, position: Int) {
        val musicVideos = musicVideosList[position]
        holder.bind(musicVideos)
    }

    override fun getItemCount(): Int {
         return musicVideosList.size
    }
}