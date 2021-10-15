package com.my.flavor2.activity

import com.my.flavor2.model.TestModelFlavor2
import com.my.test2.databinding.ActivityFlavor2Binding
import com.my.test2.kotlinbase.BaseActivity

class MyTestFlavor2: BaseActivity<ActivityFlavor2Binding, TestModelFlavor2>() {
    override fun onPrepare() {

    }

    override fun getBindingInstance(): ActivityFlavor2Binding {
       return ActivityFlavor2Binding.inflate(layoutInflater)
    }

    override fun getModelInstance(): TestModelFlavor2 {
        return TestModelFlavor2(binding!!,this)
    }

}