package com.bacteriainc.demo.domain.interactors;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public abstract class UseCase<T> {
    CompositeDisposable compositeDisposable;
    Scheduler executorThread;
    Scheduler uiThread;

    public UseCase(Scheduler executorThread, Scheduler uiThread) {
        this.compositeDisposable = new CompositeDisposable();
        this.executorThread = executorThread;
        this.uiThread = uiThread;
    }

    public void execute(DisposableObserver<T> disposableObserver) {
        if (disposableObserver == null) {
            throw new IllegalArgumentException("Disposable can't be null");
        }
        final Observable<T> observable =
                this.createObservableCaseUse().subscribeOn(executorThread)
                        .observeOn(uiThread);

        DisposableObserver observer = observable.subscribeWith(disposableObserver);
        compositeDisposable.add(observer);
    }

    public void dispose() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    protected abstract Observable<T> createObservableCaseUse();
}
