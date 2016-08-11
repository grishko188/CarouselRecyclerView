package com.grishko188.library;

import android.animation.Animator;

/**
 * Created by Unreal Mojo
 *
 * @author Grishko Nikita
 *         on 10.08.2016.
 */
public abstract class SimpleAnimatorListener implements Animator.AnimatorListener {
    private boolean canceled;

    @Override
    public void onAnimationStart(Animator animator) {
        canceled = false;
    }

    @Override
    public void onAnimationCancel(Animator animator) {
        canceled = true;
    }

    @Override
    public void onAnimationRepeat(Animator animator) {

    }

    public boolean wasCanceled() {
        return canceled;
    }
}
