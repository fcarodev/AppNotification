package com.portfolio.appnotification.model

data class NotificationPush(
    val assetUrl:MutableList<AssetNoti>? = mutableListOf(),//list of possible aasets (video,image,etc)
)

data class ButtonAction(
    val text:String? = null, //text of the button ex: go, send, download, etc
    val colorTextHex:String? = null, //color of the text ex: #FFFFFF (no transparency)
    val colorBackgroundHex:String? = null, //color of the backgrount ex: #000000 (no transparency)
    val type:String? = null, //name of the actione ex: call, mail, exdeeplink,indeeplink, webview, openapp
    val action:String? = null //action ex: +569 82..., mail@mail.com, https://example.com, deep.link://myApp
)

data class AssetNoti(
    val url:String? = null, //url of the asset ex: www.video.com/1 , www.image.com/1
    val mimeType:String? = null,// type of the asset, jpg, png, mp4, avi
    val text:String? = null,//text of the asset ex: buy now the new product of the...
    val videoConfig: VideoConfig? = null,// if the assets is a video
    val actionButton:MutableList<ButtonAction>? = mutableListOf()//list of button actions in the noti (call, send sms,send mail, open app, webview, etc)
)

data class VideoConfig(
    val autoPlay:Boolean? = false, //set if the video is autoplay: true = autoplay, false = pause video
    val autoSound:Boolean? = false // set if the video is with sound on: true: sound video, false = video mute
)