package com.example.melodymusic

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlaylistAdapter(val context: Context, private val playList: List<Playlist>) : RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    inner class PlaylistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val playListImageView: ImageView = itemView.findViewById(R.id.playlistImageView)
        val playListTextView: TextView = itemView.findViewById(R.id.playlistTextView)

        fun bind(playlist: Playlist) {
            playListImageView.setImageResource(playlist.playlistimageResId)
            playListTextView.text = playlist.playlistdname
            itemView.setOnClickListener {
                val intent = Intent(context, playlist.playlistactivityClass)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.playlist_item, parent, false)
        return PlaylistViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val playlist = playList[position]
        holder.bind(playlist)
    }

    override fun getItemCount(): Int {
        return playList.size
    }
}