package com.bacteriainc.demo.domain;

import com.bacteriainc.demo.data.entity.Category;

import java.util.List;

import io.reactivex.Observable;

public interface CategoryRepository {
    Observable<List<Category>> fetchCategories();
}
