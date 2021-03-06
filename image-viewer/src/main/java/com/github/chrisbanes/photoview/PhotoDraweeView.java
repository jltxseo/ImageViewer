package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

/**
 * @author jltxseo
 *         Created by junlintianxia on 2018/03/22.
 * @version V1.0
 * @Description
 */
public class PhotoDraweeView extends SimpleDraweeView implements IPhotoView {

    private PhotoDraweeViewAttacher mAttacher;

    private boolean mEnableDraweeMatrix = true;

    private  OnPhotoDraweeViewLoadListener onLoadListener;

    public PhotoDraweeView(Context context, GenericDraweeHierarchy hierarchy) {
        super(context, hierarchy);
        init();
    }

    public PhotoDraweeView(Context context) {
        super(context);
        init();
    }

    public PhotoDraweeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PhotoDraweeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    protected void init() {
        if (mAttacher == null || mAttacher.getDraweeView() == null) {
            mAttacher = new PhotoDraweeViewAttacher(this);
        }
    }

    public PhotoDraweeViewAttacher getAttacher() {
        return mAttacher;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        int saveCount = canvas.save();
        if (mEnableDraweeMatrix) {
            canvas.concat(mAttacher.getDrawMatrix());
        }
        super.onDraw(canvas);
        canvas.restoreToCount(saveCount);
    }

    @Override
    protected void onAttachedToWindow() {
        init();
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        mAttacher.onDetachedFromWindow();
        super.onDetachedFromWindow();
    }

    @Override
    public void setScaleType(ScaleType scaleType){
        if(scaleType == ScaleType.CENTER){
            GenericDraweeHierarchy hierarchy = getHierarchy();
            hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER);
        }else if(scaleType == ScaleType.CENTER_CROP){
            GenericDraweeHierarchy hierarchy = getHierarchy();
            hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        }else if(scaleType == ScaleType.CENTER_INSIDE){
            GenericDraweeHierarchy hierarchy = getHierarchy();
            hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE);
        }else if(scaleType == ScaleType.FIT_CENTER){
            GenericDraweeHierarchy hierarchy = getHierarchy();
            hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        }else if(scaleType == ScaleType.FIT_START){
            GenericDraweeHierarchy hierarchy = getHierarchy();
            hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_START);
        }else if(scaleType == ScaleType.FIT_END){
            GenericDraweeHierarchy hierarchy = getHierarchy();
            hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_END);
        }else if(scaleType == ScaleType.FIT_XY){
            GenericDraweeHierarchy hierarchy = getHierarchy();
            hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        }
    }

    @Override
    public ImageView getImageView() {
        return this;
    }

    @Override
    public float getMinimumScale() {
        return mAttacher.getMinimumScale();
    }

    @Override
    public float getMediumScale() {
        return mAttacher.getMediumScale();
    }

    @Override
    public float getMaximumScale() {
        return mAttacher.getMaximumScale();
    }

    @Override
    public void setMinimumScale(float minimumScale) {
        mAttacher.setMinimumScale(minimumScale);
    }

    @Override
    public void setMediumScale(float mediumScale) {
        mAttacher.setMediumScale(mediumScale);
    }

    @Override
    public void setMaximumScale(float maximumScale) {
        mAttacher.setMaximumScale(maximumScale);
    }

    @Override
    public float getScale() {
        return mAttacher.getScale();
    }

    @Override
    public void setScale(float scale) {
        mAttacher.setScale(scale);
    }

    @Override
    public void setScale(float scale, boolean animate) {
        mAttacher.setScale(scale, animate);
    }

    @Override
    public void setScale(float scale, float focalX, float focalY, boolean animate) {
        mAttacher.setScale(scale, focalX, focalY, animate);
    }

    @Override
    public boolean isZoomable() {
        return mAttacher.isZoomable();
    }

    @Override
    public void setZoomable(boolean zoomable) {
        mAttacher.setZoomable(zoomable);
    }
    @Override
    public void setOrientation(@PhotoDraweeViewAttacher.OrientationMode int orientation) {
        mAttacher.setOrientation(orientation);
    }

    @Override
    public void setZoomTransitionDuration(long duration) {
        mAttacher.setZoomTransitionDuration(duration);
    }

    @Override
    public void setAllowParentInterceptOnEdge(boolean allow) {
        mAttacher.setAllowParentInterceptOnEdge(allow);
    }

    @Override
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener listener) {
        mAttacher.setOnDoubleTapListener(listener);
    }

    @Override
    public void setOnScaleChangeListener(OnScaleChangedListener listener) {
        mAttacher.setOnScaleChangeListener(listener);
    }

    @Override
    public void setOnLongClickListener(OnLongClickListener listener) {
        mAttacher.setOnLongClickListener(listener);
    }

    @Override
    public void setOnPhotoTapListener(OnPhotoTapListener listener) {
        mAttacher.setOnPhotoTapListener(listener);
    }

    @Override
    public void setOnViewTapListener(OnViewTapListener listener) {
        mAttacher.setOnViewTapListener(listener);
    }

    @Override
    public OnPhotoTapListener getOnPhotoTapListener() {
        return mAttacher.getOnPhotoTapListener();
    }

    @Override
    public OnViewTapListener getOnViewTapListener() {
        return mAttacher.getOnViewTapListener();
    }

    @Override
    public void update(int imageInfoWidth, int imageInfoHeight) {
        mAttacher.update(imageInfoWidth, imageInfoHeight);
    }

    public boolean isEnableDraweeMatrix() {
        return mEnableDraweeMatrix;
    }

    public void setEnableDraweeMatrix(boolean enableDraweeMatrix) {
        mEnableDraweeMatrix = enableDraweeMatrix;
    }

    public void setPhotoUri(Uri uri) {
        setPhotoUri(null,uri);
    }

    public void setPhotoUri(@Nullable Context context,Uri uri) {
        setPhotoUri(context,uri,true);
    }

    public void setPhotoUri(@Nullable Context context,Uri uri,boolean isAutoAnimation) {
        mEnableDraweeMatrix = false;
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setCallerContext(context)
                .setAutoPlayAnimations(isAutoAnimation)
                .setUri(uri)
                .setOldController(getController())
                .setControllerListener(new BaseControllerListener<ImageInfo>() {
                    @Override
                    public void onFailure(String id, Throwable throwable) {
                        super.onFailure(id, throwable);
                        mEnableDraweeMatrix = false;
                        if(onLoadListener != null){
                            onLoadListener.onFailure(id,throwable);
                        }
                    }

                    @Override
                    public void onFinalImageSet(String id, ImageInfo imageInfo,
                                                Animatable animatable) {
                        super.onFinalImageSet(id, imageInfo, animatable);
                        mEnableDraweeMatrix = true;
                        if (imageInfo != null) {
                            update(imageInfo.getWidth(), imageInfo.getHeight());
                        }
                        if(onLoadListener != null){
                            onLoadListener.onFinalImageSet(id,imageInfo,animatable);
                        }
                    }

                    @Override
                    public void onIntermediateImageFailed(String id, Throwable throwable) {
                        super.onIntermediateImageFailed(id, throwable);
                        mEnableDraweeMatrix = false;
                        if(onLoadListener != null){
                            onLoadListener.onIntermediateImageFailed(id,throwable);
                        }
                    }

                    @Override
                    public void onIntermediateImageSet(String id, ImageInfo imageInfo) {
                        super.onIntermediateImageSet(id, imageInfo);
                        mEnableDraweeMatrix = true;
                        if (imageInfo != null) {
                            update(imageInfo.getWidth(), imageInfo.getHeight());
                        }
                        if(onLoadListener != null){
                            onLoadListener.onIntermediateImageSet(id,imageInfo);
                        }
                    }
                })
                .build();
        if(onLoadListener != null){
            onLoadListener.onLoadStarted();
        }
        setController(controller);
    }

    public void setOnLoadListener(OnPhotoDraweeViewLoadListener onLoadListener) {
        this.onLoadListener = onLoadListener;
    }

    public interface OnPhotoDraweeViewLoadListener{
        /**
         * 开始加载图片
         */
         void onLoadStarted();

        /**
         * 图片加载成功后会被回调
         * @param id
         * @param imageInfo
         * @param animatable
         */
         void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable);

        /**
         * 图片解码成功后会被回调
         * @param id
         * @param imageInfo
         */
         void onIntermediateImageSet(String id, ImageInfo imageInfo);

        /**
         * 图片解码失败后会被回调
         * @param id
         * @param throwable
         */
         void onIntermediateImageFailed(String id, Throwable throwable);

        /**
         * 图片加载失败后会被回调
         * @param id
         * @param throwable
         */
        void onFailure(String id, Throwable throwable);
    }
}
