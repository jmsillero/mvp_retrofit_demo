package com.bacteriainc.demo.data.repository;

import com.bacteriainc.demo.data.CategoryRemoteProvider;
import com.bacteriainc.demo.data.entity.Category;
import com.bacteriainc.demo.domain.CategoryRepository;

import java.util.List;

import io.reactivex.Observable;

public class CategoryRepositoryImpl implements CategoryRepository {
    private CategoryRemoteProvider categoryRemoteProvider;

    public CategoryRepositoryImpl() {
        categoryRemoteProvider = new CategoryRemoteProvider();
    }

    @Override
    public Observable<List<Category>> fetchCategories() {
        return categoryRemoteProvider.fetchCategories();
    }
}
