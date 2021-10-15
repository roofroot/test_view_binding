package com.my.flavor2.model

import android.app.Activity
import android.view.View
import com.my.test2.databinding.ActivityFlavor2Binding
import com.my.test2.kotlinbase.MyBaseModel

class TestModelFlavor2(binding: ActivityFlavor2Binding, context: Activity) :
    MyBaseModel<ActivityFlavor2Binding>(binding, context) {
    override fun onClick(v: View?) {
    }

}