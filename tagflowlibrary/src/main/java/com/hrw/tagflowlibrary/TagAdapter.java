package com.hrw.tagflowlibrary;

import android.view.View;

import java.util.List;

/**
 * @version 1.0.0
 * @author:hrw
 * @date:2018/12/10 8:49
 * @desc:
 */
public abstract class TagAdapter<T> {
    private List<T> mData;

    public TagAdapter(List<T> data) {
        mData = data;
    }

    public List<T> getData() {
        return mData;
    }

    protected abstract View bindView(T t, int position);
}
