package com.my.test2.javabase;

import android.app.Activity;
import android.view.View;

import androidx.viewbinding.ViewBinding;

/**
 * @author : yx^_^
 * @e-mail : 565749553@qq.com
 * @date : 2020/3/5 18:09
 * @desc : better than before
 */
public abstract class SimpleBaseModel <T extends ViewBinding> implements View.OnClickListener {

    protected T binding;
    protected Activity context;
    public  SimpleBaseModel(T binding, Activity context){
        this.binding=binding;
        this.context=context;
    }
    public SimpleBaseModel(T binding){
        this.binding=binding;
    }
    protected void bindListener(View... views){
        for (View view:
             views) {
            view.setOnClickListener(this);
        }
    }
}
