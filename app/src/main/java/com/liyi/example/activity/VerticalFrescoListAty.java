package com.liyi.example.activity;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.liyi.example.PhotoViewerLoadFactoryImpl;
import com.liyi.example.R;
import com.liyi.example.Utils;
import com.liyi.example.adapter.RecyclerAdp;
import com.liyi.viewer.ImageViewerUtil;
import com.liyi.viewer.PhotoExtParam;
import com.liyi.viewer.PhotoViewer;
import com.liyi.viewer.ViewData;
import com.liyi.viewer.dragger.ImageDraggerType;

import java.util.List;

/**
 * 竖向列表页面
 */
public class VerticalFrescoListAty extends BaseActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager mLinearManager;
    private RecyclerAdp mAdapter;

    private Point mScreenSize;

    @Override
    int onBindLayoutResID() {
        return R.layout.aty_vertical_fresco_list;
    }

    @Override
    void onInit(Bundle savedInstanceState) {
        initView();
        addListener();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerview);

        mLinearManager = new LinearLayoutManager(this);
        mLinearManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(mLinearManager);

        mAdapter = new RecyclerAdp(1);
        List<String> mImageList = Utils.getImageList();
        mAdapter.setData(mImageList);
        initData();
    }

    private void initData() {
        mScreenSize = ImageViewerUtil.getScreenSize(this);
        for (int i = 0, len = mViewList.size(); i < len; i++) {
            ViewData viewData = mViewList.get(i);
            viewData.setTargetX(ImageViewerUtil.dp2px(this, 10));
            viewData.setTargetWidth(mScreenSize.x - ImageViewerUtil.dp2px(this, 20));
            viewData.setTargetHeight(ImageViewerUtil.dp2px(this, 200));
        }
    }

    private void addListener() {
        mAdapter.setOnItemClickCallback(new RecyclerAdp.OnItemClickCallback() {
            @Override
            public void onItemClick(int position, ImageView view) {
                int[] location = new int[2];
                // 获取在整个屏幕内的绝对坐标
                view.getLocationOnScreen(location);
                ViewData viewData = mViewList.get(position);
                // 去掉状态栏的高度
                viewData.setTargetY(location[1]);
                mViewList.set(position, viewData);


                PhotoExtParam photoExtParam =  new PhotoExtParam.Builder()
                        .doDrag(true)
                        .dragType(ImageDraggerType.DRAG_TYPE_WX)
                        .photoViewerLoadFactory(PhotoViewerLoadFactoryImpl.class)
                        .startPosition(position)
                        .viewDataList(mViewList)
                        .build();
                PhotoViewer.startDefaultPhotoViewer(VerticalFrescoListAty.this,photoExtParam);
            }
        });
        recyclerView.setAdapter(mAdapter);
        mLinearManager.scrollToPositionWithOffset(0, 0);
    }
}
