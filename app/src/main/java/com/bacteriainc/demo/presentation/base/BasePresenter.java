package com.bacteriainc.demo.presentation.base;


public interface BasePresenter<V extends BaseView> {
    void onAttach(V view);

    void onDetach();
}
