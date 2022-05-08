package com.example.tiktok

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter(private val context: Context, private val videoList: ArrayList<VideoModel>) :
    RecyclerView.Adapter<VideoAdapter.viewHolder>() {

    private var isPause = false
//    private var stopPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.sample_video, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.video.setVideoPath(videoList[position].video)
//        holder.video.setMediaController(MediaController(context))
        holder.video.setOnPreparedListener(MediaPlayer.OnPreparedListener {
            it.start()
        })
        holder.video.setOnCompletionListener {
            it.start()
        }
        holder.video.setOnClickListener {
            if (isPause) {
//                holder.video.seekTo(stopPosition)
//                holder.video.resume()
                holder.video.start()
                holder.pauseIcon.visibility = View.GONE
                isPause = false
            } else {
                holder.video.pause()
//                stopPosition = holder.video.currentPosition
                holder.pauseIcon.visibility = View.VISIBLE
                isPause = true
            }
        }
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val video = itemView.findViewById<VideoView>(R.id.video)
        val pauseIcon = itemView.findViewById<ImageView>(R.id.pause)
    }

}