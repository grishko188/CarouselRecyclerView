package com.grishko188.carouselrecyclerview.utils;

import android.content.Context;


public class ConvertUtil {

    private ConvertUtil() {
    }


    public static float dp2px(Context ctx, float px) {
        return px / ctx.getResources().getDisplayMetrics().density;
    }

    public static float px2dp(Context ctx, float dp) {
        return dp * ctx.getResources().getDisplayMetrics().density;
    }

}