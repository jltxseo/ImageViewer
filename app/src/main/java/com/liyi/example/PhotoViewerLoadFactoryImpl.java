package com.liyi.example;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.image.ImageInfo;
import com.github.chrisbanes.photoview.PhotoDraweeView;
import com.liyi.viewer.IPhotoViewerLoadFactory;
import com.liyi.viewer.ImageLoader;
import com.liyi.viewer.PhotoViewerLifeCycle;
import com.liyi.viewer.widget.BaseScaleView;

/**
 * @author jltxseo
 * Created by junlintianxia on 2018/09/11.
 */
public class PhotoViewerLoadFactoryImpl implements IPhotoViewerLoadFactory{
    public PhotoViewerLoadFactoryImpl() {
    }

    @Override
    public ImageLoader<String> createImageLoader() {
        return new ImageLoader<String>() {
            @Override
            public void displayImage(int position, String source, ImageView imageView) {
                final BaseScaleView scaleImageView= (BaseScaleView) imageView.getParent();
                if (imageView instanceof PhotoDraweeView){
                    PhotoDraweeView draweeView = (PhotoDraweeView)imageView;
                    GenericDraweeHierarchy hierarchy = draweeView.getHierarchy();
                    if (hierarchy != null){
                        hierarchy.setFadeDuration(300);
                        hierarchy.setFailureImage(R.drawable.img_viewer_placeholder);
                    }
                    draweeView.setHierarchy(hierarchy);
                    draweeView.setOnLoadListener(new PhotoDraweeView.OnPhotoDraweeViewLoadListener() {
                        @Override
                        public void onLoadStarted() {
                            scaleImageView.showProgess();
                        }

                        @Override
                        public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                            scaleImageView.hideProgress();
                        }

                        @Override
                        public void onIntermediateImageSet(String id, ImageInfo imageInfo) {
                            scaleImageView.hideProgress();
                        }

                        @Override
                        public void onIntermediateImageFailed(String id, Throwable throwable) {
                            scaleImageView.hideProgress();
                        }

                        @Override
                        public void onFailure(String id, Throwable throwable) {
                            scaleImageView.hideProgress();
                        }
                    });
                    draweeView.setPhotoUri(Uri.parse(source));

                }
            }
        };
    }

    @Override
    public PhotoViewerLifeCycle createPhotoViewerLifeCycle() {
        return new PhotoViewerLifeCycle() {
            @Override
            public void onCreate(Context context, @Nullable Bundle savedInstanceState) {
                super.onCreate(context, savedInstanceState);
            }

            @Override
            public void onResume(Context context) {
                super.onResume(context);
            }

            @Override
            public void onPause(Context context) {
                super.onPause(context);
            }

            @Override
            public void onDestroy(Context context) {
                super.onDestroy(context);
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    protected PhotoViewerLoadFactoryImpl(Parcel in) {
    }

    public static final Creator<PhotoViewerLoadFactoryImpl> CREATOR = new Creator<PhotoViewerLoadFactoryImpl>() {
        @Override
        public PhotoViewerLoadFactoryImpl createFromParcel(Parcel source) {
            return new PhotoViewerLoadFactoryImpl(source);
        }

        @Override
        public PhotoViewerLoadFactoryImpl[] newArray(int size) {
            return new PhotoViewerLoadFactoryImpl[size];
        }
    };
}
