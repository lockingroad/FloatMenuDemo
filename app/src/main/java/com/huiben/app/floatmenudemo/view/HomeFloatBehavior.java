package com.huiben.app.floatmenudemo.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


/**
 * Created by liuran on 2017/9/16.
 * 未使用
 */

public class HomeFloatBehavior extends CoordinatorLayout.Behavior<View> {

    private String TAG="HomeFloatBehavior";

    int offsetTotal=0;
    private boolean scrolling;

    public HomeFloatBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeFloatBehavior() {
    }


    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
//        offset(child,dyConsumed);

        offsetTotal+=dyConsumed;
        Log.e(TAG, "onNestedScroll: "+offsetTotal);

    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    public void offset(View child,int dy){
        int old = offsetTotal;
        int top = offsetTotal - dy;
        top = Math.max(top, -child.getHeight());
        top = Math.min(top, 0);
        offsetTotal = top;
        if (old == offsetTotal){
            scrolling = false;
            return;
        }
        int delta = offsetTotal-old;
//        Log.e(TAG, "delta: "+delta);
        child.offsetTopAndBottom(delta);
        scrolling = true;
    }

}
