package com.kefelon.loodosmovie.extensions

import android.view.View

fun View.setEmptyViewVisible(isVisible: Boolean) {
    this.visibility = if (isVisible) View.VISIBLE else View.GONE
}