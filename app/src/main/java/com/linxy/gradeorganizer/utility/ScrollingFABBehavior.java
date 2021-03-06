package com.linxy.gradeorganizer.utility;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

import com.linxy.gradeorganizer.utility.Utils;

/**
 * Created by Linxy on 3/8/2015 at 13:59
 * Working on Grade Organizer in com.linxy.gradeorganizer
 */
public class ScrollingFABBehavior extends CoordinatorLayout.Behavior<FloatingActionButton>{

    private int toolbarHeight;

    public ScrollingFABBehavior(Context context, AttributeSet attrs){
        super(context, attrs);
        this.toolbarHeight = Utils.getToolbarHeight(context);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        return dependency instanceof ControllableAppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        if(dependency instanceof ControllableAppBarLayout){
            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
            int fabBottomMargin = lp.bottomMargin;
            int distanceToScroll = fab.getHeight() + fabBottomMargin;
            float ratio = (float) dependency.getY()/(float)toolbarHeight;
            fab.setTranslationY(-distanceToScroll * ratio);
        }
        return true;
    }
}
