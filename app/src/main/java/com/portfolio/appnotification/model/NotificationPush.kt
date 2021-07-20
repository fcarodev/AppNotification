package com.portfolio.appnotification.model

data class NotificationPush(
    val type:String? = null, //type of the notification ex: video, image, push
    val assetUrl:MutableList<AssetUrl>? = mutableListOf(),
    val actionButton:MutableList<ButtonAction>? = mutableListOf()


)

data class ButtonAction(
    val text:String? = null, //text of the button ex: go, send, download, etc
    val colorTextHex:String? = null, //color of the text ex: #FFFFFF (no transparency)
    val colorBackgroundHex:String? = null, //color of the backgrount ex: #000000 (no transparency)
    val action:ActionType? = null //type of the action button
)

data class ActionType(
    val type:String? = null, //name of the actione ex: call, mail, exdeeplink,indeeplink, webview, openapp
    val action:String? = null //action ex: phone number, mail, url web, deeplink to anoher app
)
data class AssetUrl(
    val url:String? = null
)