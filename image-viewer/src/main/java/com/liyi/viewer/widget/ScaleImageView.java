package com.liyi.viewer.widget;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
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

    @Override
    public RectF getPhotoViewDisplayRect() {
        IPhotoView iPhotoView = getPhotoView();
        if(iPhotoView instanceof PhotoImageView){
            Drawable d = iPhotoView.getImageView().getDrawable();
            if (d != null) {
                RectF mDisplayRect = new RectF();
                mDisplayRect.set(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
                return mDisplayRect;
            }
        }
        return null;
    }
}
