package com.liyi.viewer.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.github.chrisbanes.photoview.IPhotoView;
import com.github.chrisbanes.photoview.PhotoImageView;

/**
 * 可缩放图片的自定义 View（即 viewPager 的 item）
 */
public class ScaleImageView extends BaseScaleView {
    public ScaleImageView(@NonNull Context context) {
        super(context);
    }

    public ScaleImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScaleImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public IPhotoView createPhotoView(Context context) {
        return new PhotoImageView(context);
    }
}
