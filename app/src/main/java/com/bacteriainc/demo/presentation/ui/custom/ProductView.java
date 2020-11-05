package com.bacteriainc.demo.presentation.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bacteriainc.demo.R;
import com.bacteriainc.demo.data.entity.Price;
import com.bacteriainc.demo.data.entity.Product;
import com.bacteriainc.demo.presentation.ui.adapter.CategoryListAdapter;
import com.bumptech.glide.Glide;

import java.util.List;


public class ProductView extends ConstraintLayout {
    private Product product;
    private CategoryListAdapter.OnItemClickListener onItemClickListener;

    TextView tvTitle;
    TextView tvDescription;
    TitlePriceView firstPriceView;
    TitlePriceView secondPriceView;
    ImageView ivProductImage;

    public ProductView(Context context, Product product, CategoryListAdapter.OnItemClickListener onItemClickListener) {
        super(context);
        this.product = product;
        this.onItemClickListener = onItemClickListener;
        init(null, 0);
    }

    public ProductView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public ProductView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void initValues() {
        tvTitle.setText(product.getTitulo());
        tvDescription.setText(product.getDescripcion());
        List<Price> prices = product.getPrecios();

        // TODO: In case of more 2 prices Use a list view instead separated views
        if (prices != null) {
            int size = prices.size();
            if (size > 0) {
                firstPriceView.setPrice(prices.get(0));
            }
            if (size > 1) {
                secondPriceView.setPrice(prices.get(1));
            }
        }

        // load image url using Glide
        Glide.with(getContext())
                .load(product.getUrlImagen())
                .error(R.drawable.ic_error)
                .into(ivProductImage);
    }

    private void init(AttributeSet attrs, int defStyle) {
        View v = inflate(getContext(), R.layout.item_product_view, this);
        tvTitle = v.findViewById(R.id.tv_title);
        tvDescription = v.findViewById(R.id.tv_description);
        firstPriceView = v.findViewById(R.id.first_price_view);
        secondPriceView = v.findViewById(R.id.second_price_view);
        ivProductImage = v.findViewById(R.id.iv_product_image);

        v.setOnClickListener(view -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(product);
            }
        });

        initValues();
    }


}