package com.github.chrisbanes.photoview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * @author jltxseo
 * Created by junlintianxia on 2018/09/10.
 */
public class PhotoImageView extends PhotoView implements IPhotoView{
    public PhotoImageView(Context context) {
        super(context);
    }

    public PhotoImageView(Context context, AttributeSet attr) {
        super(context, attr);
    }

    public PhotoImageView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
    }

    @Override
    public ImageView getImageView() {
        return this;
    }

    @Override
    public void setOrientation(int orientation) {

    }

    @Override
    public void setZoomTransitionDuration(long duration) {

    }

    @Override
    public OnPhotoTapListener getOnPhotoTapListener() {
        return null;
    }

    @Override
    public OnViewTapListener getOnViewTapListener() {
        return null;
    }

    @Override
    public void update(int imageInfoWidth, int imageInfoHeight) {

    }

}
