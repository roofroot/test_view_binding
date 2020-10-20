package com.dsf.vms.base

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.view.KeyEvent
import androidx.viewbinding.ViewBinding
import com.dsf.vms.R
import com.dsf.vms.manager.MyActivityManager
import com.dsf.vms.utils.ProgressDialogUtils
import com.dsf.vms.utils.statue_bar.Eyes

/**
 * @author : yx^_^
 * @e-mail : 565749553@qq.com
 * @date : 2020/3/6 10:59
 * @desc : better than before
 */
abstract class MyBaseModel<T : ViewBinding?> : BaseModel<T> {
    protected var mProgressDialog: ProgressDialog? = null
    protected var TAG: String

    constructor(binding: T, context: Activity) : super(binding, context) {
     
        TAG = binding!!.toString()
        MyActivityManager.getInstance().pushActivity(context)
    }



    constructor(binding: T) : super(binding) {
        Eyes.setStatusBarLightMode(context, context!!.resources.getColor(stateBarColor))
        TAG = binding!!.toString()
    }

    override fun onDestroy() {
        MyActivityManager.getInstance().popActivity(context)
    }

    override fun onStart() {}
    override fun onKeyDown(keyCode: Int, event: KeyEvent) {}
    override fun toLoginView() {


    }

    protected fun finishAnim() {
        context!!.finish()
        context!!.overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right)
    }

    protected fun startActivityAnim(intent: Intent?) {
        context!!.startActivity(intent)
        context!!.overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left)
    }

    protected fun startActivityForResultAnim(intent: Intent?, requestCode: Int) {
        context!!.startActivityForResult(intent, requestCode)
        context!!.overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left)
    }

    override fun onNewIntent(intent: Intent?) {}
    override fun onBackPressed() {}

    /**
     * 取消进度条
     */
    fun cancelProgressDialog() {
        if (mProgressDialog == null) {
            return
        } else {
            mProgressDialog!!.cancel()
        }
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent) {}
    override fun dispatchKeyEvent(event: KeyEvent) {}

    /**
     * 显示进度条
     */
    fun showProgressDialog(msg: String?) {

//        if (null == mProgressDialog) {
        mProgressDialog = ProgressDialogUtils.showProgressDialog(context, msg)
        //        } else {
//            mProgressDialog.setMessage(msg);
//        }
        mProgressDialog?.show()
        //
//        if (null != mProgressDialog) {
//            if (!mProgressDialog.isShowing()) {
//                mProgressDialog.show();
//            }
////
//        }
    }

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
