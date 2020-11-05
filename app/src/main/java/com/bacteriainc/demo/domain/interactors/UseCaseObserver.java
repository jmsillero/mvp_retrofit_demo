package com.bacteriainc.demo.domain.interactors;

import io.reactivex.observers.DisposableObserver;


public abstract class UseCaseObserver<T> extends DisposableObserver<T> {
    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
