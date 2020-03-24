package com.my.test2;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.my.test2.databinding.ActivityMainBinding;

import androidx.annotation.NonNull;

/**
 * @author : yx^_^
 * @e-mail : 565749553@qq.com
 * @date : 2020/3/6 14:26
 * @desc : better than before
 */
public class MainModel extends BaseModel<ActivityMainBinding> {
    TitleModel titleModel;
    TitleModel2 titleModel2;
    public MainModel(ActivityMainBinding binding, Activity context) {
        super(binding, context);
        titleModel=new TitleModel(binding.title,context);
        titleModel.setTitle("标题");
        titleModel2=new TitleModel2(binding.title,context);
        titleModel2.setTitle();
        binding.title.tx.setText("标题");//第三种写法
    }

    public MainModel(ActivityMainBinding binding) {
        super(binding);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

    }

    @Override
    public void onClick(View v) {

    }
}
