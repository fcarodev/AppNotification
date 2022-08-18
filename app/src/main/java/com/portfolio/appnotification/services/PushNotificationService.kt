package com.portfolio.appnotification.services

import android.util.Log
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson
import com.orhanobut.hawk.Hawk
import com.portfolio.appnotification.model.NotificationPush
import com.portfolio.appnotification.utils.decodeBase64
import com.portfolio.appnotification.utils.encodeBase64

class PushNotificationService : FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)

    }

    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)

        val obj = p0.data.getValue("encode")
        val person: NotificationPush =  jacksonObjectMapper().readValue(obj.decodeBase64())
        Log.d("MainActivity", Gson().toJson(person))
    }
}