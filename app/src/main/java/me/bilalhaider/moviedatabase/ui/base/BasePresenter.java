package me.bilalhaider.moviedatabase.ui.base;

import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;

public class BasePresenter<V extends BaseView> implements LifecycleObserver {

    private V mCurrentView;

}
