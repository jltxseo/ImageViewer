package com.liyi.viewer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.liyi.viewer.listener.OnPreviewStatusListener;
import com.liyi.viewer.widget.BaseScaleView;
import com.liyi.viewer.widget.ImageViewer;

import java.util.ArrayList;

/**
 * @author jltxseo
 * Created by junlintianxia on 2018/09/11.
 */
public class PhotoViewerActivity extends AppCompatActivity implements OnPreviewStatusListener {
    public static final String KEY_PHOTO_PARAM = "key_photo_param";

    private ImageViewer imagePreview;
    private PhotoExtParam extParam;
    /**
     * 生命周期回调接口
     */
    private PhotoViewerLifeCycle photoViewerLifeCycle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_viewer_layout);
        if(getIntent() != null){
            Bundle bundle = getIntent().getExtras();
            if(bundle != null && bundle.containsKey(KEY_PHOTO_PARAM)){
                extParam = bundle.getParcelable(KEY_PHOTO_PARAM);
            }
        }
        //恢复状态
        if(savedInstanceState != null) {
            restoreState(savedInstanceState);
        }

        if(extParam == null){
            //参数错误直接关闭界面
            finish();
        }
        imagePreview = findViewById(R.id.imagePreivew);
        initView(savedInstanceState);
    }

    private void initView(Bundle savedInstanceState){
        imagePreview.setOnPreviewStatusListener(this);
        imagePreview.setStartPosition(extParam.getStartPosition());
        if(extParam.getShowIndex() != null){
            imagePreview.showIndex(extParam.getShowIndex());
        }
        if(extParam.getDoDrag() != null){
            imagePreview.doDrag(extParam.getDoDrag());
        }

        if(extParam.getDragType() != null){
            imagePreview.setDragType(extParam.getDragType());
        }
        //进行viewDataList的拷贝
        imagePreview.setViewData(extParam.getViewDataList() != null ? new ArrayList<ViewData>(extParam.getViewDataList() ): new ArrayList<ViewData>());

        if(extParam.getPhotoViewType() != null){
            imagePreview.setPhotoViewType(extParam.getPhotoViewType());
        }

        if(extParam.getDoEnterAnim() != null){
            imagePreview.doEnterAnim(extParam.getDoEnterAnim());
        }

        if(extParam.getDoExitAnim() != null){
            imagePreview.doExitAnim(extParam.getDoExitAnim());
        }

        if(extParam.getDuration() != null){
            imagePreview.setDuration(extParam.getDuration());
        }

        if(extParam.getImageMaxScale() != null){
            imagePreview.setImageMaxScale(extParam.getImageMaxScale());
        }

        if(extParam.getImageMinScale() != null){
            imagePreview.setImageMinScale(extParam.getImageMinScale());
        }

        if(extParam.getPhotoViewerLoadFactory() != null){

            //初始化IPhotoViewerLoadFactory接口
            try {
                Class<? extends IPhotoViewerLoadFactory> factoryClass = extParam.getPhotoViewerLoadFactory() ;
                IPhotoViewerLoadFactory factory = factoryClass.newInstance();
                ImageLoader<?> imageLoader  = factory.createImageLoader();
                photoViewerLifeCycle = factory.createPhotoViewerLifeCycle();
                if(imageLoader != null){
                    imagePreview.setImageLoader(imageLoader);
                }
            } catch (Exception e) {
            }
        }

        imagePreview.watch();

        if(photoViewerLifeCycle != null){
            photoViewerLifeCycle.onCreate(this,savedInstanceState);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(photoViewerLifeCycle != null){
            photoViewerLifeCycle.onResume(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(photoViewerLifeCycle != null){
            photoViewerLifeCycle.onPause(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(photoViewerLifeCycle != null){
            photoViewerLifeCycle.onDestroy(this);
        }
    }

    @Override
    public void onPreviewStatus(int state, BaseScaleView imagePager) {
        if (state == com.liyi.viewer.ImageViewerState.STATE_COMPLETE_CLOSE) {
            imagePreview.setOnPreviewStatusListener(null);
            onBackPressed();
        }
    }

    /**
     * 恢复数据
     * @param savedInstanceState
     */
    private void restoreState(Bundle savedInstanceState){
        extParam = savedInstanceState.getParcelable(KEY_PHOTO_PARAM);
    }
    /**
     * 保存状态
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY_PHOTO_PARAM,extParam);
    }

    /**
     * 监听返回键
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean b = imagePreview.onKeyDown(keyCode, event);
        if (b) {
            return b;
        }
        return super.onKeyDown(keyCode, event);
    }
}
