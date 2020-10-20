package com.dsf.vms.base

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding, M : BaseModel<*>> :
    AppCompatActivity() {
    protected var binding: T? = null
    protected var model: M? = null
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        Log.e("keycode", keyCode.toString() + "")
        model?.onKeyDown(keyCode, event)
        return super.onKeyDown(keyCode, event)
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onPrepare()
        binding = getBindingInstance()
        setContentView(binding!!.root)
        model = getModelInstance()
    }

    override fun onDestroy() {
        super.onDestroy()
         model?.onDestroy()
    }

    override fun onStop() {
        super.onStop()
        model?.onStop()
    }

    override fun onPause() {
        super.onPause()
        model?.onPause()
    }

    override fun onResume() {
        super.onResume()
        model?.onResume()
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        model?.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRestart() {
        super.onRestart()
        model?.onRestart()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        model?.onNewIntent(intent)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        model?.onKeyUp(keyCode, event)
        return super.onKeyUp(keyCode, event)
    }

    override fun onStart() {
        super.onStart()
        model?.onStart()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        model?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        model?.onBackPressed()
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        model?.dispatchKeyEvent(event)
        return super.dispatchKeyEvent(event)
    }

    protected abstract fun onPrepare()
    protected abstract fun getBindingInstance(): T
    protected abstract fun getModelInstance(): M
 
}
