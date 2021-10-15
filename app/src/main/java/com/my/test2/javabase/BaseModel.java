package com.my.test2.javabase;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/**
 * @author : yx^_^
 * @e-mail : 565749553@qq.com
 * @date : 2020/3/5 18:09
 * @desc : better than before
 */
public abstract class BaseModel<T extends ViewBinding>  implements View.OnClickListener {
    protected T  binding;
    protected Activity context;
    public BaseModel(T binding,Activity context){
        this.binding=binding;
        this.context=context;

    }
    public BaseModel(T binding){
        this.binding=binding;
    }


    public abstract void onResume();
    public abstract void onActivityResult(int requestCode, int resultCode, Intent data);

    public abstract void onPause();
    public abstract void onDestroy();

    public abstract void onRestart();
    public abstract void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                                @NonNull int[] grantResults);
    protected void bindListener(View... views){
        for (View view:
             views) {
            view.setOnClickListener(this);
        }
    }

}
