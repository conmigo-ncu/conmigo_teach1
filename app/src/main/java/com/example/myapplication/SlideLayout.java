package com.example.myapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by mac on 2017/6/15.
 */

//條目滑動效果
public class SlideLayout extends LinearLayout {

    private ViewDragHelper mDragHelper;
    private View contentView;
    private View actionView;
    private int dragDistance;
    private final double AUTO_OPEN_SPEED_LIMIT = 800.0;
    private int draggedX;

    public SlideLayout(Context context) {
        super(context);
        init();
    }

    public SlideLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SlideLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //初始化
    public void init (){
        mDragHelper = ViewDragHelper.create(this, new DragHelperCallback());

    }

    @Override
    public boolean callOnClick() {
        return super.callOnClick();
    }
    /*當你觸摸屏幕，移動的時候，就會回調這個方法。
    它會返回兩個參數。第一個參數，就是你觸摸的那個控件。
    第二個就是ＩＤ。
    返回值又代表什麼呢？返回ture,就是代筆允許拖動這個控件。
    返回false就代表不允許拖動這個控件.。這裡我只允許拖動主控件。*/

    //把容器的事件處理委托給ViewDragHelper對象

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (mDragHelper.shouldInterceptTouchEvent(event)) {
            return true;
        }
        return super.onInterceptTouchEvent(event);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragHelper.processTouchEvent(event);
        return true;

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        contentView = getChildAt(0);
        actionView = getChildAt(1);
        actionView.setVisibility(GONE);
    }



    //設置拖動的距離為actionView的寬度
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        dragDistance = actionView.getMeasuredWidth();
        //System.out.println("rightTop"+actionView.getTop());
    }


    private class DragHelperCallback extends ViewDragHelper.Callback {


        //用來確定contentView和actionView是可以拖動的
        @Override
        public boolean tryCaptureView(View view, int i) {
            return view == contentView || view == actionView;
        }

        //被拖動的view位置改變的時候調用，如果被拖動的view是contentView，
        // 我們需要在這裡更新actionView的位置
        @Override
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            draggedX = left;
            if (changedView == contentView) {
                actionView.offsetLeftAndRight(dx);
            } else {
                contentView.offsetLeftAndRight(dx);
            }
            //actionView 是否可見
            //0    --------   VISIBLE    可見
            //4    --------   INVISIBLE    不可見但是占用佈局空間
            //8    --------   GONE    不可見也不占用佈局空間
            if (actionView.getVisibility() == View.GONE) {
                actionView.setVisibility(View.VISIBLE);
            }
            if (left==25)
            {
                actionView.setVisibility(View.GONE);
            }
            invalidate();  //刷新View
        }

        //用來限制view在x軸上拖動
        //@Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            if (child == contentView) {
                final int leftBound = getPaddingLeft();
                final int minLeftBound = -leftBound - dragDistance;
                final int newLeft = Math.min(Math.max(minLeftBound, left), 25);
                //System.out.println("content "+newLeft);
                return newLeft;
            } else {
                //getMeasuredWidth()獲取全部長度 包括隱藏的
                final int minLeftBound = getPaddingLeft() + contentView.getMeasuredWidth() - dragDistance;
                final int maxLeftBound = getPaddingLeft() + contentView.getMeasuredWidth() + getPaddingRight();
                final int newLeft = Math.min(Math.max(left, minLeftBound), maxLeftBound);
                System.out.println("action "+newLeft);
                return newLeft;
            }
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            //System.out.println("top "+top);
            if(top!=25)
            {
                top=25;
            }

            return top;
        }

        //用來限制view可以拖動的范圍
        //@Override
        public int getViewHorizontalDragRange(View child) {
            return dragDistance;
        }

        @Override
        public int getViewVerticalDragRange(View child) {
            return 0;
        }

        //根據滑動手勢的速度以及滑動的距離來確定是否顯示actionView。
        // smoothSlideViewTo方法用來在滑動手勢之後實現慣性滑動效果
        //@Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            boolean settleToOpen = false;
            if (xvel > AUTO_OPEN_SPEED_LIMIT) {
                settleToOpen = false;
            } else if (xvel < -AUTO_OPEN_SPEED_LIMIT) {
                settleToOpen = true;
            } else if (draggedX <= -dragDistance / 2) {
                settleToOpen = true;
            } else if (draggedX > -dragDistance / 2) {
                settleToOpen = false;
            }

            final int settleDestX = settleToOpen ? -dragDistance : 0;
            mDragHelper.smoothSlideViewTo(contentView, settleDestX, 0);
            ViewCompat.postInvalidateOnAnimation(SlideLayout.this);
        }
    }
}