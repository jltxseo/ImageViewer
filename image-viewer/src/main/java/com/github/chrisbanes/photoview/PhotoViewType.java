package com.github.chrisbanes.photoview;


import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@IntDef({PhotoViewType.PHOTO_IMAGE_VIEW,
        PhotoViewType.PHOTO_DRAWEE_VIEW,})
@Retention(RetentionPolicy.SOURCE)
public @interface PhotoViewType {
    /**
     * PhotoImageView 直接使用ImageView，使用glide picasso异步加载
     */
    int PHOTO_IMAGE_VIEW = 1;
    /**
     * PhtotoDraweeView 使用Fresco异步加载
     */
    int PHOTO_DRAWEE_VIEW = 2;
}
