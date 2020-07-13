package com.kefelon.loodosmovie.utils

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.downloadFromUrl(url: String?) {

    if (!TextUtils.isEmpty(url)) {

        Glide.with(context)
            .setDefaultRequestOptions(RequestOptions())
            .load(url)
            .into(this)
    }
}


@BindingAdapter("android:downloadUrl")
fun downloadImage(view: ImageView, url: String?) {
    if (!TextUtils.isEmpty(url)) {
        view.downloadFromUrl(url)
    }
}

