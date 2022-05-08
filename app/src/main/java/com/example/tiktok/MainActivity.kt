package com.example.tiktok

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var videoList: ArrayList<VideoModel>
    private lateinit var videoAdapter: VideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.navigationBarColor = resources.getColor(R.color.black)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        this.theme.applyStyle(R.style.FullScreen, false)

        videoList = ArrayList()

        videoList.add(VideoModel("android.resource://$packageName/${R.raw.d}"))
        videoList.add(VideoModel("android.resource://$packageName/${R.raw.b}"))
        videoList.add(VideoModel("android.resource://$packageName/${R.raw.c}"))
        videoList.add(VideoModel("android.resource://$packageName/${R.raw.a}"))
        videoList.add(VideoModel("android.resource://$packageName/${R.raw.e}"))

        videoAdapter = VideoAdapter(this, videoList)
        viewPager2.adapter = videoAdapter

    }
}