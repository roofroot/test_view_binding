package com.dsf.vms

import com.dsf.vms.base.BaseActivity
import com.dsf.vms.databinding.ActivityTestBinding

class TestActivity: BaseActivity<ActivityTestBinding, TestModel>() {
    override fun onPrepare() {

    }

    override fun getBindingInstance(): ActivityTestBinding {
       return ActivityTestBinding.inflate(layoutInflater)
    }

    override fun getModelInstance(): TestModel {
       return  TestModel(binding!!,this) ;
    }

}