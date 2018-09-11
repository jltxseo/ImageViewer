package com.liyi.viewer;

import android.os.Parcelable;

/**
 * @author jltxseo
 * Created by junlintianxia on 2018/09/11.
 */
public interface IPhotoViewerLoadFactory extends Parcelable{
    ImageLoader<?> createImageLoader();
    PhotoViewerLifeCycle createPhotoViewerLifeCycle();
}
