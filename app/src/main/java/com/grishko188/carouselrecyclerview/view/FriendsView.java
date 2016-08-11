package com.grishko188.carouselrecyclerview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.grishko188.carouselrecyclerview.R;
import com.grishko188.library.CarouselRecyclerView;

/**
 * Created by Unreal Mojo
 *
 * @author Grishko Nikita
 *         on 11.08.2016.
 */
public class FriendsView extends LinearLayout implements CarouselRecyclerView.OnCenterProximityListener {

    public FriendsView(Context context) {
        super(context);
        init(context);
    }

    public FriendsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FriendsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FriendsView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.layout_friend, this);
        setAlpha(0.6f);
        setScaleX(0.9f);
        setScaleY(0.9f);
    }

    @Override
    public void onCenterPosition(boolean var1) {
        animate().alpha(1f).scaleX(1f).scaleY(1f).setDuration(150);
    }

    @Override
    public void onNonCenterPosition(boolean var1) {
        animate().alpha(0.6f).scaleX(0.9f).scaleY(0.9f).setDuration(150);
    }
}

