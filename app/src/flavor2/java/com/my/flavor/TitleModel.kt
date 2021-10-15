package com.my.flavor

import android.app.Activity
import android.view.View
import com.my.test2.databinding.LayoutTitleBinding
import com.my.test2.kotlinbase.SimpleBaseModel

/**
 * @author : yx^_^
 * @e-mail : 565749553@qq.com
 * @date : 2020/3/24 14:15
 * @desc : better than before
 */
class TitleModel(binding: LayoutTitleBinding, context: Activity) : SimpleBaseModel<LayoutTitleBinding>(binding,context) {
    var name=""
    fun setTitle() {
        binding.tx.setText("test")

    }

    private fun func() {
    }

    override fun onClick(v: View?) {

    }

}