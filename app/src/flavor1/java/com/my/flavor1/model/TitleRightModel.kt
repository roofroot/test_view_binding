package com.my.flavor1.model

import android.app.Activity
import android.view.View
import com.my.test2.databinding.LayoutTitleRightBinding
import com.my.test2.kotlinbase.MyBaseModel

class TitleRightModel(binding: LayoutTitleRightBinding,context:Activity): MyBaseModel<LayoutTitleRightBinding>(binding,context) {
    fun setRightText(str:String="aa"){

    }
    override fun onClick(v: View?) {

    }
}