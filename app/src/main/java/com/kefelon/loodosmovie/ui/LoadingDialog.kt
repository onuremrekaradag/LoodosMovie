package com.kefelon.loodosmovie.ui

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.kefelon.loodosmovie.R
import com.kefelon.loodosmovie.base.BaseActivity

class LoadingView : Dialog {

    constructor(activity: FragmentActivity) : super(activity) {
        val window = window!!
        window.requestFeature(Window.FEATURE_NO_TITLE)
        try {
            setContentView(activity.getLayoutInflater().inflate(R.layout.item_loading_layout, null))
            window.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            window.setGravity(Gravity.CENTER)
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setCanceledOnTouchOutside(false)
            setCancelable(false)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}