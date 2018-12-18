package com.hrw.tagflowlibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @version 1.0.0
 * @author:hrw
 * @date:2018/12/10 8:47
 * @desc:
 */
public class TagFlowView extends ViewGroup {


    private int viewHorizontalSpace = 20;
    private int viewVerticalSpace = 20;
    private TagModel model = TagModel.AVERAGE;
//    private int viewSpace = 20;


    Map<Integer, List<View>> viewMap = new LinkedHashMap<>();
    List<View> views = new ArrayList<>();
    TagAdapter mTagAdapter;

    public TagFlowView(Context context) {
        this(context, null);
    }

    public TagFlowView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TagFlowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;
        int height = 0;

        if (mTagAdapter == null) return;
        removeAllViews();
        views.clear();
        viewMap.clear();
        System.out.println("----------------------");
        for (int i = 0; i < mTagAdapter.getData().size(); i++) {
            View view = mTagAdapter.bindView(mTagAdapter.getData().get(i), i);
            views.add(view);
            addView(view);
            measureChild(view, widthMeasureSpec, heightMeasureSpec);
        }
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
            if (mTagAdapter.getData() != null) {
                int childViewWidth = 0;
                int lineNumber = 0;
                for (int i = 0; i < views.size(); i++) {
                    View view = views.get(i);
                    int childWidth = view.getMeasuredWidth();
                    if (childViewWidth + childWidth > widthSize && childViewWidth < widthSize) {
                        childViewWidth = 0;
                        lineNumber++;
                    }
                    List<View> views = viewMap.get(lineNumber);
                    if (views == null) {
                        views = new ArrayList<>();
                        views.add(view);
                        viewMap.put(lineNumber, views);
                    } else {
                        views.add(view);
                    }
                    if (i < (views.size() - 1)) {
                        childViewWidth += (childWidth + viewHorizontalSpace);
                    } else {
                        childViewWidth += childWidth;
                    }
                }
            }
        } else {
            width = getPaddingLeft() + getPaddingRight();
            if (mTagAdapter.getData() != null) {
                int childViewWidth = 0;
                int lineNumber = 0;
                for (View view : views) {
                    childViewWidth += view.getMeasuredWidth();
                }
            }
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = getPaddingBottom() + getPaddingTop();
            int childHeight = 0;
            Set<Map.Entry<Integer, List<View>>> entries = viewMap.entrySet();
            for (Map.Entry<Integer, List<View>> entry : entries) {
                List<View> views = entry.getValue();
                int heightCount = 0;
                for (View view : views) {
                    int h = view.getMeasuredHeight();
                    if (heightCount < h) {
                        heightCount = h;
                    }
                }
                childHeight += heightCount;
            }
            height += childHeight;
        }
        if (viewMap.size() > 1) {
            setMeasuredDimension(width, height + (viewMap.size() - 1) * viewVerticalSpace);
        } else {
            setMeasuredDimension(width, height);
        }
    }

    private float firstX;
    private float firstY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result = super.onInterceptTouchEvent(ev);
        System.out.println("onInterceptTouchEvent:" + ev.getAction() + " result:" + result);
        return result;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean result = super.dispatchTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                firstX = event.getX();
                firstY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
//                result = true;
                break;
            case MotionEvent.ACTION_UP:
                break;

        }
        System.out.println("dispatchTouchEvent:" + event.getAction() + " result:" + result);
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);
        System.out.println("onTouchEvent:" + event.getAction() + " result:" + result);
        float x = event.getRawX();
        float y = event.getRawY();
//        System.out.println("x:" + x + " y:" + y);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int middleX = (int) (x - event.getRawX());
                int middleY = (int) (y - event.getRawY());
//                System.out.println("x:" + x + " event.getRawX():" + event.getRawX() + " y:" + y + " event.getRawY():" + event.getRawY());
//                scrollBy(middleX, middleY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return result;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Set<Map.Entry<Integer, List<View>>> entries = viewMap.entrySet();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();

        int heightCount = 0;
        for (Map.Entry<Integer, List<View>> entry : entries) {//遍历每行View
            List<View> views = entry.getValue();
            int leftSpace = 0;
            int maxHeight = 0;
            switch (model) {
                case NORMAL:
                    break;
                case AVERAGE:
                    int totalWidth = 0;
                    for (int i = 0; i < views.size(); i++) {
                        View view = views.get(i);
                        totalWidth += view.getMeasuredWidth();
                    }
                    int mm = getMeasuredWidth() - totalWidth - paddingLeft - paddingRight;
                    viewHorizontalSpace = views.size() - 1 == 0 ? viewHorizontalSpace : mm / (views.size() - 1);
                    break;
            }

            //遍历每行View并且进行位置放置
            for (int i = 0; i < views.size(); i++) {
                View view = views.get(i);
                if (i == 0) {
                    view.layout(paddingLeft + leftSpace, paddingTop + heightCount, paddingLeft + leftSpace + view.getMeasuredWidth(), paddingTop + heightCount + view.getMeasuredHeight());
                    leftSpace += (view.getMeasuredWidth());
                } else {
                    view.layout(paddingLeft + leftSpace + viewHorizontalSpace, paddingTop + heightCount, paddingLeft + leftSpace + view.getMeasuredWidth() + viewHorizontalSpace, paddingTop + heightCount + view.getMeasuredHeight());
                    leftSpace += (view.getMeasuredWidth() + viewHorizontalSpace);
                }
            }
            //遍历获取每行View中高度最大的
            for (int i = 0; i < views.size(); i++) {
                View view = views.get(i);
                if (maxHeight < view.getMeasuredHeight()) {
                    maxHeight = view.getMeasuredHeight();
                }
            }
            heightCount += (maxHeight + viewVerticalSpace);
        }
    }

    public TagFlowView setAdapter(TagAdapter adapter) {
        mTagAdapter = adapter;
        invalidate();
        return this;
    }


}
