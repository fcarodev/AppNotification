package com.portfolio.appnotification.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.tabs.TabLayout
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import com.portfolio.appnotification.R
import com.portfolio.appnotification.fragment.PageAdapter
import com.portfolio.appnotification.model.*
import kotlinx.android.synthetic.main.item_noti.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_noti)
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result
            Log.d("MainActivity", token!!)
        })

        val assetLst = mutableListOf<AssetNoti>()
        val buttons = mutableListOf<ButtonAction>()
        buttons.add(ButtonAction("web", "#ffffff", "#000000", "web", "https://www.google.cl/"))
        buttons.add(ButtonAction("comprar", "#ffffff", "#000000", "web", "https://www.google.cl/"))
        assetLst.add(
            AssetNoti(
                "https://cdn.videvo.net/videvo_files/video/premium/video0383/small_watermarked/_News127_preview.mp4",
                "video",
                "Los -40° Farenheit y los -40° Celsius son la misma temperatura",
                VideoConfig(
                    true,
                    true
                )
            )
        )
        assetLst.add(
            AssetNoti(
                "https://placekitten.com/g/400/500",
                "img",
                "Los elefantes usan los pliegues de la espalda para pitearse mosquitos",
                null
            )
        )
        assetLst.add(
            AssetNoti(
                "https://placekitten.com/g/400/301",
                "img",
                "El segundo nombre del Pato Donald es «Fauntleroy»",
                null,
                buttons
            )
        )
        assetLst.add(
            AssetNoti(
                "https://cdn.videvo.net/videvo_files/video/premium/video0413/small_watermarked/_TrailerNews13_preview.mp4",
                "video",
                "Los armadillos son bravos para la tontera y dan a luz a cuatrillizos",
                VideoConfig(
                    true,
                    true
                )
            )
        )
        assetLst.add(
            AssetNoti(
                "https://cdn.videvo.net/videvo_files/video/free/2013-08/small_watermarked/hd0983_preview.mp4",
                "video",
                "Se necesitan 27 mil árboles diarios para cubrir la demanda de papel higiénico que el mundo necesita por día.",
                VideoConfig(
                    true,
                    true
                ),
                buttons
            )
        )
        assetLst.add(
            AssetNoti(
                "https://cdn.videvo.net/videvo_files/video/free/2013-08/small_watermarked/hd0992_preview.mp4",
                "video",
                "La mayoría de la gente sabe que la miel es el alimento menos perecedero que existe Lo que pocos saben es que de las 20 mil especies de abeja que existen, solo 4 producen miel.",
                null,
                buttons
            )
        )


        val noti = NotificationPush(assetLst)
        Log.d("MainActivity", Gson().toJson(noti))


        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = PageAdapter(noti, supportFragmentManager)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)

        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                txtPosition.text = (position+1).toString()
                textviewText.text = noti.assetUrl!![position].text

            }

            override fun onPageSelected(position: Int) {
                // Check if this is the page you want.
            }
        })
    }

}