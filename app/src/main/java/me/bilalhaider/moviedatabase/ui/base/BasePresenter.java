package me.bilalhaider.moviedatabase.ui.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends BaseView> implements LifecycleObserver {

    public V mCurrentView;
    private CompositeDisposable mCompositeDisposable;

    public void attachView(V view) {
        if (mCurrentView != null) {
            detachView();
        }
        mCurrentView = view;
    }

    private void detachView() {
        mCurrentView = null;
    }

    private void initCompositeDisposable() {
        if (mCompositeDisposable != null && mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
    }

    private void clearCompositeDisposable() {
        if (mCompositeDisposable != null)
            mCompositeDisposable.dispose();
    }

    public void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void presenterOnDestroy() {
        clearCompositeDisposable();
        detachView();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void presenterOnCreate() {
        initCompositeDisposable();
    }


}