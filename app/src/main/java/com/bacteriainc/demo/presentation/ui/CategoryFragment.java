package com.bacteriainc.demo.presentation.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bacteriainc.demo.R;
import com.bacteriainc.demo.data.entity.Category;
import com.bacteriainc.demo.presentation.categoryList.CategoryListPresenter;
import com.bacteriainc.demo.presentation.categoryList.CategoryListPresenterImpl;
import com.bacteriainc.demo.presentation.categoryList.CategoryListView;
import com.bacteriainc.demo.presentation.ui.adapter.CategoryListAdapter;

import java.util.List;


public class CategoryFragment extends Fragment implements CategoryListView {

    //TODO: Inject Presenter using Dagger...
    CategoryListPresenter<CategoryListView> presenter;
    private CategoryListAdapter categoryListAdapter;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;


    public CategoryFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Initialize presenter
        presenter = new CategoryListPresenterImpl<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        Context context = view.getContext();
        progressBar = view.findViewById(R.id.progressBar);
        recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        categoryListAdapter = new CategoryListAdapter(context, product -> {
            NavDirections action = CategoryFragmentDirections.actionCategoryFragmentToDetailFragment(product);
            Navigation.findNavController(view).navigate(action);
        });


        recyclerView.setAdapter(categoryListAdapter);

        presenter.onAttach(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Fetch all categories...
        presenter.fetchCategories();
    }

    /*
     * Implemented View methods
     * */
    @Override
    public void onCategoriesSuccessful(List<Category> categoryList) {
        categoryListAdapter.updateCategories(categoryList);
    }

    @Override
    public void onError(String error) {
        if (getActivity() != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(R.string.error_label);
            builder.setMessage(error);        // add a button
            builder.setPositiveButton(R.string.ok_button, null);        // create and show the alert dialog
            builder.setNegativeButton(getString(R.string.retry), (dialogInterface, i) -> presenter.fetchCategories());
            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }

    @Override
    public void onError(int code) {

    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);

    }

    @Override
    public void hideLoading() {
        recyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
    }
}