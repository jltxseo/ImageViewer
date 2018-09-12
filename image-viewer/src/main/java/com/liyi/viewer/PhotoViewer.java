package com.liyi.viewer;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import com.liyi.viewer.dragger.ImageDraggerType;

import java.util.ArrayList;
import java.util.List;

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
    public static void startDefaultPhotoViewer(Activity activity,PhotoExtParam extParam){
        if(activity != null && extParam !=null && extParam.getViewDataList() != null && extParam.getViewDataList().size() > 0){
            Intent intent = new Intent();
            intent.setClass(activity,PhotoViewerActivity.class);
            intent.putExtra(PhotoViewerActivity.KEY_PHOTO_PARAM,extParam);
            activity.startActivity(intent);
        }
    }

    /**
     * 直接打开一个默认布局的相册
     * @param activity
     * @param url
     */
    public static void startDefaultPhotoViewer(Activity activity, String url,Class<? extends IPhotoViewerLoadFactory> val){
        if(activity != null && !TextUtils.isEmpty(url)){
            ViewData viewData = new ViewData();
            viewData.setImageUrl(url);
            startDefaultPhotoViewer(activity,viewData,val);
        }
    }

    /**
     * 直接打开一个默认布局的相册
     * @param activity
     * @param viewData
     */
    public static void startDefaultPhotoViewer(Activity activity, ViewData viewData, Class<? extends IPhotoViewerLoadFactory> val){
        if(activity != null && viewData != null){
            List<ViewData> viewDataList = new ArrayList<>();
            viewDataList.add(viewData);
            startDefaultPhotoViewer(activity,viewDataList,val);
        }
    }

    /**
     * 直接打开一个默认布局的相册
     * @param activity
     * @param viewDataList
     * @param val
     */
    public static void startDefaultPhotoViewer(Activity activity, List<ViewData> viewDataList, Class<? extends IPhotoViewerLoadFactory> val){
        startDefaultPhotoViewer(activity,viewDataList,0,val);
    }


    /**
     * 直接打开一个默认布局的相册
     * @param activity
     * @param viewDataList
     * @param startPos
     */
    public static void startDefaultPhotoViewer(Activity activity, List<ViewData> viewDataList, int startPos, Class<? extends IPhotoViewerLoadFactory> val){
        if(activity != null && viewDataList != null && viewDataList.size() > 0){
            PhotoExtParam photoExtParam =  new PhotoExtParam.Builder()
                    .doDrag(true)
                    .dragType(ImageDraggerType.DRAG_TYPE_WX)
                    .photoViewerLoadFactory(val)
                    .startPosition(startPos)
                    .viewDataList(viewDataList)
                    .build();
            startDefaultPhotoViewer(activity,photoExtParam);
        }
    }

}
