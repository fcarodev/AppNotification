package com.portfolio.appnotification

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import com.portfolio.appnotification.model.ActionType
import com.portfolio.appnotification.model.AssetUrl
import com.portfolio.appnotification.model.ButtonAction
import com.portfolio.appnotification.model.NotificationPush

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result
            Log.d("MainActivity",token!!)
        })

        val assetLst = mutableListOf<AssetUrl>()
        assetLst.add(AssetUrl("url1"))
        assetLst.add(AssetUrl("url2"))
        assetLst.add(AssetUrl("url3"))
        assetLst.add(AssetUrl("url4"))
        val buttons = mutableListOf<ButtonAction>()
        buttons.add(ButtonAction("ir","#ffffff","#000000", ActionType("call","123123123")))
        buttons.add(ButtonAction("web","#ffffff","#000000", ActionType("web","https://www.google.cl/")))
        buttons.add(ButtonAction("comprar","#ffffff","#000000",  ActionType("web","https://www.google.cl/")))
        var noti = NotificationPush("image",assetLst,buttons)
        Log.d("MainActivity", Gson().toJson(noti))

    }
}