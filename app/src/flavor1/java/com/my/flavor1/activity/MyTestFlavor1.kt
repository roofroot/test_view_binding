package com.my.flavor1.activity

import com.my.flavor1.model.TestModelFlavor1
import com.my.test2.databinding.ActivityFlavor1Binding
import com.my.test2.kotlinbase.BaseActivity

class MyTestFlavor1: BaseActivity<ActivityFlavor1Binding, TestModelFlavor1>() {
    override fun onPrepare() {

    }

    override fun getBindingInstance(): ActivityFlavor1Binding {
       return ActivityFlavor1Binding.inflate(layoutInflater)
    }

    override fun getModelInstance(): TestModelFlavor1 {
        return TestModelFlavor1(binding!!,this)
    }

}