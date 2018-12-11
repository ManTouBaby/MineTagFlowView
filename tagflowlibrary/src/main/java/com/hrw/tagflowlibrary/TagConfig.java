package com.hrw.tagflowlibrary;

import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;

/**
 * @version 1.0.0
 * @author:hrw
 * @date:2018/12/11 10:17
 * @desc:
 */
public class TagConfig {
    private static TagConfig mTagConfig;

    private int selectColor;
    private int selectBG;
    private int normalColor;
    private int normalBG;
    private int tagPaddingL;
    private int tagPaddingR;
    private int tagPaddingT;
    private int tagPaddingB;

    private TagConfig() {
    }

    public static TagConfig create() {
        if (mTagConfig == null) mTagConfig = new TagConfig();
        return mTagConfig;
    }

    public int getSelectColor() {
        return selectColor;
    }

    public TagConfig setSelectColor(@ColorInt int selectColor) {
        this.selectColor = selectColor;
        return mTagConfig;
    }

    public int getSelectBG() {
        return selectBG;
    }

    public TagConfig setSelectBG(@DrawableRes int selectBG) {
        this.selectBG = selectBG;
        return mTagConfig;
    }

    public int getNormalColor() {
        return normalColor;
    }

    public TagConfig setNormalColor(@ColorInt int normalColor) {
        this.normalColor = normalColor;
        return mTagConfig;
    }

    public int getNormalBG() {
        return normalBG;
    }

    public TagConfig setNormalBG(@DrawableRes int normalBG) {
        this.normalBG = normalBG;
        return mTagConfig;
    }


    public int getTagPaddingL() {
        return tagPaddingL;
    }

    public TagConfig setTagPaddingL(int tagPaddingL) {
        this.tagPaddingL = tagPaddingL;
        return mTagConfig;
    }

    public int getTagPaddingR() {
        return tagPaddingR;
    }

    public TagConfig setTagPaddingR(int tagPaddingR) {
        this.tagPaddingR = tagPaddingR;
        return mTagConfig;
    }

    public int getTagPaddingT() {
        return tagPaddingT;
    }

    public TagConfig setTagPaddingT(int tagPaddingT) {
        this.tagPaddingT = tagPaddingT;
        return mTagConfig;
    }

    public int getTagPaddingB() {
        return tagPaddingB;
    }

    public TagConfig setTagPaddingB(int tagPaddingB) {
        this.tagPaddingB = tagPaddingB;
        return mTagConfig;
    }
}
