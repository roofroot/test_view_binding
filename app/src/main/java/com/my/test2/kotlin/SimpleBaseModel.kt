package com.dsf.dsfwarehouse.base

import android.app.Activity
import android.view.View
import androidx.viewbinding.ViewBinding

/**
 * @author : yx^_^
 * @e-mail : 565749553@qq.com
 * @date : 2020/3/5 18:09
 * @desc : better than before
 */
abstract class SimpleBaseModel<T : ViewBinding?> : View.OnClickListener {
    protected var binding: T
    protected var context: Activity? = null

    constructor(binding: T, context: Activity?) {
        this.binding = binding
        this.context = context
    }

    constructor(binding: T) {
        this.binding = binding
    }

    protected fun bindListener(vararg views: View) {
        for (view in views) {
            view.setOnClickListener(this)
        }
    }
}