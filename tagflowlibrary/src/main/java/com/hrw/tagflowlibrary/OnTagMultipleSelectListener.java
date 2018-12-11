package com.hrw.tagflowlibrary;

import java.util.List;

/**
 * @version 1.0.0
 * @author:hrw
 * @date:2018/12/11 11:22
 * @desc:
 */
public interface OnTagMultipleSelectListener<T> {
    void tagSelectClick(List<T> mData, T t, int position);
}
