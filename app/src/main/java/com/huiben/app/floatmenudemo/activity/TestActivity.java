package com.huiben.app.floatmenudemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import com.huiben.app.floatmenudemo.R;
import com.huiben.app.floatmenudemo.fragment.TestHomeFragment;

/**
 * Created by liuran on 2017/9/16.
 * 未使用
 */

public class TestActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiivty_test);
        FragmentManager fm=getSupportFragmentManager();
        fm.beginTransaction().add(R.id.test_frag,new TestHomeFragment()).commit();
    }
}
