package com.grishko188.carouselrecyclerview.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;

/**
 * Created by Unreal Mojo
 *
 * @author Grishko Nikita
 *         on 03.11.2015.
 */
public class PlaceHolder {


    public static Drawable rect(int color, int width, int height) {
        ShapeDrawable rect = new ShapeDrawable(new RectShape());
        rect.setIntrinsicHeight(height);
        rect.setIntrinsicWidth(width);
        rect.getPaint().setColor(color);
        return rect;
    }

    public static Drawable round(int color, int diameter) {
        ShapeDrawable oval = new ShapeDrawable(new OvalShape());
        oval.setIntrinsicHeight(diameter);
        oval.setIntrinsicWidth(diameter);
        oval.getPaint().setColor(color);
        return oval;
    }
}
