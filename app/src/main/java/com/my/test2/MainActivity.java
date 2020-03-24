package com.my.test2;

import com.my.test2.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainModel> {

    @Override
    protected void onPrepare() {

    }

    @Override
    protected ActivityMainBinding getBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected MainModel getModel() {
        return new MainModel(binding,this);
    }
}
