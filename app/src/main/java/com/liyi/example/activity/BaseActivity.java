package com.liyi.example.activity;


import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.liyi.example.Utils;
import com.liyi.viewer.ViewData;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity extends AppCompatActivity {
    protected List<ViewData> mViewList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(onBindLayoutResID());
        List<String>  mImageList = Utils.getImageList();
        for (int i = 0, len = mImageList.size(); i < len; i++) {
            ViewData viewData = new ViewData();
            viewData.setImageUrl(mImageList.get(i));
            mViewList.add(viewData);
        }
        onInit(savedInstanceState);
    }

    @LayoutRes
    abstract int onBindLayoutResID();

    abstract void onInit(Bundle savedInstanceState);
}
