package com.portfolio.appnotification.utils

import android.app.Activity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> Map<String, Any>.toDataClass(): T {
    return convert()
}

inline fun <I, reified O> I.convert(): O {
    val gson = Gson()
    val json = gson.toJson(this)
    return gson.fromJson(json, object : TypeToken<O>() {}.type)
}

fun Activity.color(@ColorRes color:Int) = ContextCompat.getColor(this,color)

fun Any?.isNull() = this == null

fun Activity.toast(msg:String, length:Int = Toast.LENGTH_LONG){
    Toast.makeText(this,msg,length).show()
}

fun ImageView.load(url:String){
    if(url.isNotEmpty()){
        Glide.with(this.context).load(url).into(this)
    }
}

fun EditText.beforeTextChanged(listener:(String) -> Unit){
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            listener(s.toString())
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
        }

    })
}
fun EditText.onTextChanged(listener:(String) -> Unit){
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            listener(s.toString())
        }

        override fun afterTextChanged(s: Editable?) {
        }

    })
}
fun EditText.afterTextChanged(listener:(String) -> Unit){
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            listener(s.toString())
        }

    })
}