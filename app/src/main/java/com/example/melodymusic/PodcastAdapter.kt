package com.example.melodymusic

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PodcastAdapter(val context: Context, private val podcastList: List<Podcast>) : RecyclerView.Adapter<PodcastAdapter.PodcastViewHolder>() {

    inner class PodcastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val podcastImageView: ImageView = itemView.findViewById(R.id.podcastImageView)
        val podcastTitleTextView: TextView = itemView.findViewById(R.id.podcastTitleTextView)

        fun bind(podcast: Podcast) {
            podcastImageView.setImageResource(podcast.podimageResId)
            podcastTitleTextView.text = podcast.podname
            itemView.setOnClickListener {
                val intent = Intent(context, podcast.podactivityClass)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodcastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.podcast_item, parent, false)
        return PodcastViewHolder(view)
    }

    override fun onBindViewHolder(holder: PodcastViewHolder, position: Int) {
        val podcast = podcastList[position]
        holder.bind(podcast)
    }

    override fun getItemCount(): Int {
        return podcastList.size
    }
}
