package com.my.test2.kotlinbase

import android.app.Activity
import android.content.Intent
import android.view.KeyEvent
import androidx.viewbinding.ViewBinding

/**
 * @author : yx^_^
 * @e-mail : 565749553@qq.com
 * @date : 2020/3/6 10:59
 * @desc : better than before
 */
abstract class MyBaseModel<T : ViewBinding> : BaseModel<T> {
    protected var TAG: String

    constructor(binding: T, context: Activity) : super(binding, context) {
     
        TAG = binding.toString()
    }



    constructor(binding: T) : super(binding) {

        TAG = binding.toString()
    }


    override fun onDestroy() {

    }

    override fun onStart() {}
    override fun onKeyDown(keyCode: Int, event: KeyEvent) {}
    override fun toLoginView() {


    }

    protected fun finishAnim() {
        context!!.finish()

    }

    protected fun startActivityAnim(intent: Intent?) {
        context!!.startActivity(intent)

    }

    protected fun startActivityForResultAnim(intent: Intent?, requestCode: Int) {
        context!!.startActivityForResult(intent, requestCode)
    }

    override fun onNewIntent(intent: Intent?) {}
    override fun onBackPressed() {}


    override fun onKeyUp(keyCode: Int, event: KeyEvent) {}
    override fun dispatchKeyEvent(event: KeyEvent) {}



    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray
    ) {
    }

    override fun onRestart() {}
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
    }

    override fun onResume() {}
    override fun onPause() {}
    override fun onStop() {}
}
