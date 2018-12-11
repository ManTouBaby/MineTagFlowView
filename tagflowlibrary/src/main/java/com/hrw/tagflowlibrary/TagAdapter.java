package com.hrw.tagflowlibrary;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0
 * @author:hrw
 * @date:2018/12/11 9:09
 * @desc:
 */
public abstract class TagAdapter<T> {
    protected List<TextView> mSelectView = new ArrayList<>();
    protected List<T> mSelectData = new ArrayList<>();
    protected List<T> mData;
    protected Context mContext;
    protected float density;

    public TagAdapter(Context context, List<T> data) {
        mData = data;
        mContext = context;
        density = mContext.getResources().getDisplayMetrics().density;
    }

    public TagAdapter(List<T> data) {
        mData = data;
    }

    public List<T> getData() {
        return mData;
    }

    protected abstract View bindView(T t, int position);

    public List<T> getSelectData() {
        return mSelectData;
    }

    public List<TextView> getSelectView() {
        return mSelectView;
    }
}
