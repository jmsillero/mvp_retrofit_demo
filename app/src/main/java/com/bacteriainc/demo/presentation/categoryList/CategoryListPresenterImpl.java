package com.bacteriainc.demo.presentation.categoryList;

import com.bacteriainc.demo.data.entity.Category;
import com.bacteriainc.demo.domain.interactors.FetchCategoriesUseCase;
import com.bacteriainc.demo.domain.interactors.UseCaseObserver;
import com.bacteriainc.demo.presentation.base.BasePresenterImpl;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class CategoryListPresenterImpl<V extends CategoryListView> extends BasePresenterImpl<V> implements CategoryListPresenter<V> {
    //TODO: Inject USE CASE using koin or Dagger
    private FetchCategoriesUseCase fetchCategoriesUseCase;

    public CategoryListPresenterImpl() {
        fetchCategoriesUseCase = new FetchCategoriesUseCase(Schedulers.io(), AndroidSchedulers.mainThread());
    }

    @Override
    public void fetchCategories() {
        getView().showLoading();
        fetchCategoriesUseCase.execute(new CategoriesUseCaseObserver());
    }


    /**
     * Observers
     * This class provide an observer for reactive result of Categories
     */
    public final class CategoriesUseCaseObserver extends UseCaseObserver<List<Category>> {
        @Override
        public void onNext(List<Category> categories) {
            getView().onCategoriesSuccessful(categories);
            getView().hideLoading();
        }

        @Override
        public void onError(Throwable throwable) {
            //TODO: Implement an error handler
            getView().hideLoading();
            getView().onError(throwable.getMessage());
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }
    }
}
