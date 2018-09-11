package com.liyi.viewer;

import android.app.Activity;
import android.content.Intent;

/**
 * @author jltxseo
 * Created by junlintianxia on 2018/09/11.
 */
public class PhotoViewer {

    /**
     * 直接打开一个相册Activity
     * @param activity
     * @param extParam
     */
    public static void startPhotoViewer(Activity activity,PhotoExtParam extParam){
        if(activity != null && extParam !=null){
            Intent intent = new Intent();
            intent.setClass(activity,PhotoViewerActivity.class);
            intent.putExtra(PhotoViewerActivity.KEY_PHOTO_PARAM,extParam);
            activity.startActivity(intent);
        }
    }

}
