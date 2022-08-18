package com.portfolio.appnotification.fragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import com.portfolio.appnotification.R
import com.portfolio.appnotification.model.AssetNoti
import com.portfolio.appnotification.utils.load
import com.portfolio.appnotification.utils.remove
import com.portfolio.appnotification.utils.show

class Fragment1(val noti:AssetNoti) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private lateinit var viewOfLayout: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewOfLayout =  inflater.inflate(R.layout.fragment_1, container, false)
        val imageView = viewOfLayout.findViewById<ImageView>(R.id.imageView)
        val videoView = viewOfLayout.findViewById<VideoView>(R.id.videoView)
        if(noti.mimeType == "video"){
            imageView.remove()
            videoView.show()
            videoView.load(noti.url!!)
            videoView.start()

        }else {
            imageView.show()
            videoView.remove()
            imageView.load(noti.url!!)

        }
        videoView.setOnClickListener {
            if (videoView.isPlaying){
                videoView.pause()
            }else{
                videoView.start()
            }

        }
        return viewOfLayout
    }

}