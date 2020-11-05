package com.bacteriainc.demo.presentation.categoryList;

import com.bacteriainc.demo.data.entity.Category;
import com.bacteriainc.demo.presentation.base.BaseView;

import java.util.List;

public interface CategoryListView extends BaseView {
    void onCategoriesSuccessful(List<Category> categoryList);
}
