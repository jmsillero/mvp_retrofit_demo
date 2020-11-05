package com.bacteriainc.demo.presentation.categoryList;

import com.bacteriainc.demo.presentation.base.BasePresenter;

public interface CategoryListPresenter<V extends CategoryListView> extends BasePresenter<V> {
    void fetchCategories();
}
