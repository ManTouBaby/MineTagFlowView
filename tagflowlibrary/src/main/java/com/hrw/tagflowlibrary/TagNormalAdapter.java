package com.hrw.tagflowlibrary;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * @version 1.0.0
 * @author:hrw
 * @date:2018/12/10 8:49
 * @desc:
 */
public abstract class TagNormalAdapter<T> extends TagAdapter<T> {
    OnTagClickListener<T> mOnTagClickListener;

    public TagNormalAdapter(Context context, List<T> data) {
        super(context, data);
    }


    @Override
    protected View bindView(final T t, final int position) {
        float density = mContext.getResources().getDisplayMetrics().density;
        TextView textView = new TextView(mContext);
        textView.setText(getTagValue(t));
        textView.setPadding((int) (8 * density), (int) (4 * density), (int) (8 * density), (int) (4 * density));
        textView.setBackgroundResource(R.drawable.tag_normal_bg);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnTagClickListener == null) {
                    mOnTagClickListener.tagClick(t, position);
                }
            }
        });
        return textView;
    }

    protected abstract String getTagValue(T t);


    public TagNormalAdapter setOnTagClickListener(OnTagClickListener<T> onTagClickListener) {
        this.mOnTagClickListener = onTagClickListener;
        return this;
    }
}
