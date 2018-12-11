package com.hrw.tagflowlibrary;

/**
 * @version 1.0.0
 * @author:hrw
 * @date:2018/12/11 11:22
 * @desc:
 */
public interface OnTagClickListener<T> {
    void tagClick(T t, int position);
}
