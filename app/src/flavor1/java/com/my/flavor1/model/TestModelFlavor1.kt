package com.my.flavor1.model

import android.app.Activity
import android.view.View
import com.my.test2.databinding.ActivityFlavor1Binding
import com.my.test2.kotlinbase.MyBaseModel

class TestModelFlavor1(binding: ActivityFlavor1Binding, context: Activity) :
    MyBaseModel<ActivityFlavor1Binding>(binding, context) {
    override fun onClick(v: View?) {
    }

}