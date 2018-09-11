package com.liyi.viewer;


import android.os.Parcel;
import android.os.Parcelable;

public class ViewData implements Parcelable{
    /**
     * 图片的路径，这里可以是uri的String
     */
    private String imageUrl;
    /**
     * 目标 view 的 x 轴坐标
     */
    private float targetX;
    /**
     * 目标 view 的 y 轴坐标
     */
    private float targetY;
    /**
     * 目标 view 的宽度
     */
    private float targetWidth;
    /**
     * 目标 view 的高度
     */
    private float targetHeight;
    /**
     * 图片的原始宽度
     */
    private float imageWidth;
    /**
     * 图片的原始高度
     */
    private float imageHeight;

    public ViewData() {

    }

    public ViewData(float targetX, float targetY, float targetWidth, float targetHeight) {
        this.targetX = targetX;
        this.targetY = targetY;
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getTargetX() {
        return targetX;
    }

    public void setTargetX(float targetX) {
        this.targetX = targetX;
    }

    public float getTargetY() {
        return targetY;
    }

    public void setTargetY(float targetY) {
        this.targetY = targetY;
    }

    public float getTargetWidth() {
        return targetWidth;
    }

    public void setTargetWidth(float targetWidth) {
        this.targetWidth = targetWidth;
    }

    public float getTargetHeight() {
        return targetHeight;
    }

    public void setTargetHeight(float targetHeight) {
        this.targetHeight = targetHeight;
    }

    public float getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(float imageWidth) {
        this.imageWidth = imageWidth;
    }

    public float getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(float imageHeight) {
        this.imageHeight = imageHeight;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageUrl);
        dest.writeFloat(this.targetX);
        dest.writeFloat(this.targetY);
        dest.writeFloat(this.targetWidth);
        dest.writeFloat(this.targetHeight);
        dest.writeFloat(this.imageWidth);
        dest.writeFloat(this.imageHeight);
    }

    protected ViewData(Parcel in) {
        this.imageUrl = in.readString();
        this.targetX = in.readFloat();
        this.targetY = in.readFloat();
        this.targetWidth = in.readFloat();
        this.targetHeight = in.readFloat();
        this.imageWidth = in.readFloat();
        this.imageHeight = in.readFloat();
    }

    public static final Creator<ViewData> CREATOR = new Creator<ViewData>() {
        @Override
        public ViewData createFromParcel(Parcel source) {
            return new ViewData(source);
        }

        @Override
        public ViewData[] newArray(int size) {
            return new ViewData[size];
        }
    };
}
