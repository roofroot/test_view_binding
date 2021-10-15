package com.my.test2

import com.my.test2.databinding.ActivityMainBinding
import com.my.test2.kotlinbase.BaseActivity

class MainActivity: BaseActivity<ActivityMainBinding, MainModel>() {
    override fun onPrepare() {

    }

    override fun getBindingInstance(): ActivityMainBinding {
       return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun getModelInstance(): MainModel {
        return MainModel(binding,this)
    }
}