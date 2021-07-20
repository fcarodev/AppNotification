package com.portfolio.appnotification.services

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson
import com.orhanobut.hawk.Hawk

class PushNotificationService : FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)

    }

    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)

        Log.d("MainActivity", p0.messageId!!)
        //val a = p0.data.toDataClass<NotificationPush>()
        Log.d("MainActivity", Gson().toJson(p0.data.getValue("actionButton")).replace("\\",""))
        Log.d("MainActivity", Gson().toJson(p0.data.getValue("assetUrl")))

        //Hawk.put("noti",p0.data)
        //Log.d("MainActivity", Gson().toJson(Hawk.get("noti")))

    }
}