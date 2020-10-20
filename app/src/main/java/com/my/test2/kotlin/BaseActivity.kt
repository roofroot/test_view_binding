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
    fun setStateBar(textDark: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
                val window = window
                val decorView = window.decorView
                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
                if (textDark) {
                    val option =
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                    decorView.systemUiVisibility = option
                } else {
                    val option =
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    decorView.systemUiVisibility = option
                }
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = Color.TRANSPARENT
                //导航栏颜色也可以正常设置
//                window.setNavigationBarColor(Color.TRANSPARENT);
            } else {
                val window = window
                val attributes = window.attributes
                val flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                val flagTranslucentNavigation =
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
                attributes.flags = attributes.flags or flagTranslucentStatus
                //                attributes.flags |= flagTranslucentNavigation;
                window.attributes = attributes
            }
        }
    }
}