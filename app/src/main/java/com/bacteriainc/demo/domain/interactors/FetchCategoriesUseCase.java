package com.bacteriainc.demo.domain.interactors;

import com.bacteriainc.demo.data.entity.Category;
import com.bacteriainc.demo.data.repository.CategoryRepositoryImpl;
import com.bacteriainc.demo.domain.CategoryRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class FetchCategoriesUseCase extends UseCase<List<Category>> {

    private CategoryRepository repository;

    public FetchCategoriesUseCase(Scheduler executorThread, Scheduler uiThread) {
        super(executorThread, uiThread);
        this.repository = new CategoryRepositoryImpl();
    }

    @Override
    protected Observable<List<Category>> createObservableCaseUse() {
        return repository.fetchCategories();
    }
}
