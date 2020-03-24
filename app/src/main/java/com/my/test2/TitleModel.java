package com.my.test2;

import android.app.Activity;
import android.view.View;

import com.my.test2.databinding.LayoutTitleBinding;

/**
 * @author : yx^_^
 * @e-mail : 565749553@qq.com
 * @date : 2020/3/24 14:15
 * @desc : better than before
 */
public class TitleModel extends SimpleBaseModel<LayoutTitleBinding>{
    public TitleModel(LayoutTitleBinding binding, Activity context) {
        super(binding, context);
    }
    public void setTitle(String str){
        binding.tx.setText(str);
    }
    private void func(){
        //需要重复的业务逻辑
    }
    @Override
    public void onClick(View v) {

    }

}
