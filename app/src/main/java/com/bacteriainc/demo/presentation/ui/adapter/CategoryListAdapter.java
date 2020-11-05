package com.bacteriainc.demo.presentation.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bacteriainc.demo.R;
import com.bacteriainc.demo.data.entity.Category;
import com.bacteriainc.demo.data.entity.Product;
import com.bacteriainc.demo.presentation.ui.custom.ProductView;

import java.util.ArrayList;
import java.util.List;


public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryHolder> {

    final private List<Category> categories = new ArrayList<>();
    private OnItemClickListener onItemClickListener;
    private Context context;

    public CategoryListAdapter(@NonNull Context context, @NonNull OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        this.context = context;
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new CategoryHolder(view);
    }

    public void updateCategories(List<Category> categories) {
        this.categories.clear();
        this.categories.addAll(categories);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final CategoryHolder holder, int position) {
        holder.initData(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {
        public final View mView;
        private TextView title;
        private LinearLayout llProducts;
        public Category category;

        public CategoryHolder(View view) {
            super(view);
            mView = view;
            title = mView.findViewById(R.id.cat_title);
            llProducts = mView.findViewById(R.id.ll_products);
        }

        public void initData(Category category) {
            this.category = category;
            title.setText(this.category.getCategoria());
            populateProducts();
        }

        /**
         * Populate all products of the current category
         * add each product as a new item into linear layout
         */
        private void populateProducts() {
            llProducts.removeAllViews();
            List<Product> products = category.getProductos();
            for (Product prod : products) {
                ProductView productView = new ProductView(context, prod, onItemClickListener);
                llProducts.addView(productView);
            }
            // calls invalidate in case of re calc view measure
            llProducts.invalidate();
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Product product);
    }
}
