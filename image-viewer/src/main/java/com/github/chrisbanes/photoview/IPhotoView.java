package com.github.chrisbanes.photoview;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * @author jltxseo
 *         Created by junlintianxia on 2018/09/11.
 * @version V1.0
 * @Description
 */
public interface IPhotoView extends IAttacher{

    ImageView getImageView();

    boolean isZoomable();

     void setZoomable(boolean zoomable);

    /**
     * View相关的接口
     * @param x
     */
    void setX(float x);
    void setY(float y);
    void setLayoutParams(ViewGroup.LayoutParams params);
    void setOnClickListener(View.OnClickListener l);
    void setScaleType(ImageView.ScaleType scaleType);
    Drawable getDrawable();
    int getWidth();
    int getHeight();
}
