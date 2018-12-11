package com.hrw.tagflowlibrary;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * @version 1.0.0
 * @author:hrw
 * @date:2018/12/11 10:08
 * @desc:
 */
public abstract class TagMultipleSelectAdapter<T extends TagBean> extends TagAdapter<T> {
    OnTagMultipleSelectListener mOnTagMultipleSelectListener;

    public TagMultipleSelectAdapter(Context context, List<T> data) {
        super(context, data);
    }

    @Override
    protected View bindView(final T t, final int position) {
        final TextView textView = new TextView(mContext);
        final TagConfig tagConfig = createConfig();
        textView.setText(getTagValue(t));
        textView.setPadding(tagConfig.getTagPaddingL(), tagConfig.getTagPaddingT(), tagConfig.getTagPaddingR(), tagConfig.getTagPaddingB());
        textView.setBackgroundResource(tagConfig.getNormalBG());
        textView.setTextColor(tagConfig.getNormalColor());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setSelect(!t.isSelect());
                if (t.isSelect()) {
                    mSelectView.add(textView);
                    mSelectData.add(t);
                    textView.setTextColor(tagConfig.getSelectColor());
                    textView.setBackgroundResource(tagConfig.getSelectBG());
                } else {
                    mSelectView.remove(textView);
                    mSelectData.remove(t);
                    textView.setBackgroundResource(tagConfig.getNormalBG());
                    textView.setTextColor(tagConfig.getNormalColor());
                }
                if (mOnTagMultipleSelectListener != null) {
                    mOnTagMultipleSelectListener.tagSelectClick(mSelectData, t, position);
                }
            }
        });
        return textView;
    }

    public TagMultipleSelectAdapter setOnTagMultipleSelectListener(OnTagMultipleSelectListener<T> onTagMultipleSelectListener) {
        this.mOnTagMultipleSelectListener = onTagMultipleSelectListener;
        return this;
    }

    protected TagConfig createConfig() {
        return TagConfig.create()
                .setNormalBG(R.drawable.tag_normal_bg)
                .setSelectBG(R.drawable.tag_select_bg)
                .setNormalColor(Color.parseColor("#888888"))
                .setSelectColor(Color.parseColor("#a04524"))
                .setTagPaddingB((int) (4 * density))
                .setTagPaddingT((int) (4 * density))
                .setTagPaddingL((int) (8 * density))
                .setTagPaddingR((int) (8 * density));
    }

    protected abstract String getTagValue(T t);
}
