package com.liyi.viewer.listener;

import com.liyi.viewer.widget.BaseScaleView;

/**
 * 图片的切换监听事件
 */
public interface OnImageChangedListener {

    void onImageSelected(int position, BaseScaleView view);
}
