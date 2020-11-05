package com.bacteriainc.demo.presentation.base;


public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {
    private V view;

    @Override
    public void onAttach(V view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        view = null;
    }

    public V getView() {
        return view;
    }
}
