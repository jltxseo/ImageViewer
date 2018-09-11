package com.liyi.viewer;

import android.os.Parcel;
import android.os.Parcelable;

import com.github.chrisbanes.photoview.PhotoViewType;

import java.util.List;

/**
 * @author jltxseo
 * Created by junlintianxia on 2018/09/11.
 */
public class PhotoExtParam implements Parcelable{
    /**
     * 预览的起始位置
     */
    private int startPosition;
    /**
     * 是否显示图片位置
     */
    private Boolean showIndex;
    /**
     * 图片是否可拖拽
     */
    private Boolean doDrag;
    /**
     * 图片的拖拽模式
     */
    private Integer dragType;

    /**
     * 图片资源和数据
     */
    private List<ViewData> viewDataList;

    /**
     * 最终使用哪种缩放view  PHOTO_IMAGE_VIEW：PhotoImageView    PHOTO_DRAWEE_VIEW：PhotoDraweeView
     */
    private @PhotoViewType
    Integer photoViewType;

    /**
     * 是否执行进场动画
     */
    private Boolean doEnterAnim;
    /**
     * 是否执行退场动画
     */
    private Boolean doExitAnim;
    /**
     * 进退场动画的执行时间
     */
    private Integer duration;

    /**
     * 最大的图片缩放等级
     */
    private Float imageMaxScale;
    /**
     * 最小的图片缩放等级
     */
    private Float imageMinScale;
    /**
     * 设置家族loader的桥接接口类
     */
    private Class<? extends IPhotoViewerLoadFactory> photoViewerLoadFactory;

    public int getStartPosition() {
        return startPosition;
    }

    public Boolean getShowIndex() {
        return showIndex;
    }

    public Boolean getDoDrag() {
        return doDrag;
    }

    public Integer getDragType() {
        return dragType;
    }

    public List<ViewData> getViewDataList() {
        return viewDataList;
    }

    public Integer getPhotoViewType() {
        return photoViewType;
    }

    public Boolean getDoEnterAnim() {
        return doEnterAnim;
    }

    public Boolean getDoExitAnim() {
        return doExitAnim;
    }

    public Integer getDuration() {
        return duration;
    }

    public Float getImageMaxScale() {
        return imageMaxScale;
    }

    public Float getImageMinScale() {
        return imageMinScale;
    }

    public Class<? extends IPhotoViewerLoadFactory> getPhotoViewerLoadFactory() {
        return photoViewerLoadFactory;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.startPosition);
        dest.writeValue(this.showIndex);
        dest.writeValue(this.doDrag);
        dest.writeValue(this.dragType);
        dest.writeTypedList(this.viewDataList);
        dest.writeValue(this.photoViewType);
        dest.writeValue(this.doEnterAnim);
        dest.writeValue(this.doExitAnim);
        dest.writeValue(this.duration);
        dest.writeValue(this.imageMaxScale);
        dest.writeValue(this.imageMinScale);
        dest.writeSerializable(this.photoViewerLoadFactory);
    }

    protected PhotoExtParam(Parcel in) {
        this.startPosition = in.readInt();
        this.showIndex = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.doDrag = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.dragType = (Integer) in.readValue(Integer.class.getClassLoader());
        this.viewDataList = in.createTypedArrayList(ViewData.CREATOR);
        this.photoViewType = (Integer) in.readValue(Integer.class.getClassLoader());
        this.doEnterAnim = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.doExitAnim = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.duration = (Integer) in.readValue(Integer.class.getClassLoader());
        this.imageMaxScale = (Float) in.readValue(Float.class.getClassLoader());
        this.imageMinScale = (Float) in.readValue(Float.class.getClassLoader());
        this.photoViewerLoadFactory = (Class<? extends IPhotoViewerLoadFactory>) in.readSerializable();
    }

    public static final Creator<PhotoExtParam> CREATOR = new Creator<PhotoExtParam>() {
        @Override
        public PhotoExtParam createFromParcel(Parcel source) {
            return new PhotoExtParam(source);
        }

        @Override
        public PhotoExtParam[] newArray(int size) {
            return new PhotoExtParam[size];
        }
    };

    private PhotoExtParam(Builder builder) {
        startPosition = builder.startPosition;
        showIndex = builder.showIndex;
        doDrag = builder.doDrag;
        dragType = builder.dragType;
        viewDataList = builder.viewDataList;
        photoViewType = builder.photoViewType;
        doEnterAnim = builder.doEnterAnim;
        doExitAnim = builder.doExitAnim;
        duration = builder.duration;
        imageMaxScale = builder.imageMaxScale;
        imageMinScale = builder.imageMinScale;
        photoViewerLoadFactory = builder.photoViewerLoadFactory;
    }


    public static final class Builder {
        private int startPosition;
        private Boolean showIndex;
        private Boolean doDrag;
        private Integer dragType;
        private List<ViewData> viewDataList;
        private Integer photoViewType;
        private Boolean doEnterAnim;
        private Boolean doExitAnim;
        private Integer duration;
        private Float imageMaxScale;
        private Float imageMinScale;
        private Class<? extends IPhotoViewerLoadFactory> photoViewerLoadFactory;

        public Builder() {
        }

        public Builder startPosition(int val) {
            startPosition = val;
            return this;
        }

        public Builder showIndex(boolean val) {
            showIndex = val;
            return this;
        }

        public Builder doDrag(boolean val) {
            doDrag = val;
            return this;
        }

        public Builder dragType(int val) {
            dragType = val;
            return this;
        }

        public Builder viewDataList(List<ViewData> val) {
            viewDataList = val;
            return this;
        }

        public Builder photoViewType(int val) {
            photoViewType = val;
            return this;
        }

        public Builder doEnterAnim(boolean val) {
            doEnterAnim = val;
            return this;
        }

        public Builder doExitAnim(boolean val) {
            doExitAnim = val;
            return this;
        }

        public Builder duration(int val) {
            duration = val;
            return this;
        }

        public Builder imageMaxScale(float val) {
            imageMaxScale = val;
            return this;
        }

        public Builder imageMinScale(float val) {
            imageMinScale = val;
            return this;
        }

        public Builder photoViewerLoadFactory(Class<? extends IPhotoViewerLoadFactory> val) {
            photoViewerLoadFactory = val;
            return this;
        }

        public PhotoExtParam build() {
            return new PhotoExtParam(this);
        }
    }
}
