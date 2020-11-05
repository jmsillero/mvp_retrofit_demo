package com.bacteriainc.demo.presentation.base;


public interface BaseView {
    void onError(String error);

    void onError(int code);

    void showLoading();

    void hideLoading();
}
