package com.my.test2

import android.app.Activity
import android.view.View
import androidx.viewbinding.BuildConfig
import com.my.flavor.TitleModel
import com.my.test2.databinding.ActivityMainBinding
import com.my.test2.kotlinbase.MyBaseModel

class MainModel(binding: ActivityMainBinding, context: Activity) :
    MyBaseModel<ActivityMainBinding>(binding, context) {
    init {
            TitleModel(binding.title,context)
    }
    override fun onClick(v: View?) {

    }
}