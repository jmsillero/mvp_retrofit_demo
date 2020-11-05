package com.bacteriainc.demo.presentation.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bacteriainc.demo.R;
import com.bacteriainc.demo.data.entity.Extra;
import com.bacteriainc.demo.data.entity.Price;
import com.bacteriainc.demo.data.entity.Product;
import com.bacteriainc.demo.presentation.ui.custom.ExtraGroupView;
import com.bacteriainc.demo.presentation.ui.custom.TitlePriceView;
import com.bumptech.glide.Glide;

import java.util.List;

public class DetailFragment extends Fragment {

    private Product product;
    private ImageView ivMainImage;
    private TextView tvTitle;
    private TextView tvDescription;
    private TitlePriceView firstTitlePriceView;
    private TitlePriceView secondTitlePriceView;
    private LinearLayout llExtras;


    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        setupUi(v);
        populateProduct();
        return v;
    }

    private void setupUi(View v) {
        ivMainImage = v.findViewById(R.id.iv_main_image);
        tvTitle = v.findViewById(R.id.tv_title);
        tvDescription = v.findViewById(R.id.tv_description);
        firstTitlePriceView = v.findViewById(R.id.first_price_view);
        secondTitlePriceView = v.findViewById(R.id.second_price_view);
        llExtras = v.findViewById(R.id.ll_extras);
    }

    private void populateProduct() {
        assert getArguments() != null;
        product = DetailFragmentArgs.fromBundle(getArguments()).getProduct();

        assert getContext() != null;
        Glide.with(getContext())
                .load(product.getUrlImagen())
                .error(R.drawable.ic_error)
                .into(ivMainImage);

        tvTitle.setText(product.getTitulo());
        tvDescription.setText(product.getDescripcion());

        List<Price> prices = product.getPrecios();

        // TODO: In case of more 2 prices Use a list view instead separated views
        if (prices != null) {
            int size = prices.size();
            if (size > 0) {
                firstTitlePriceView.setPrice(prices.get(0));
            }
            if (size > 1) {
                secondTitlePriceView.setPrice(prices.get(1));
            }
        }

        // populate extras
        List<Extra> extras = product.getExtras();

        // prevent duplicated views...
        llExtras.removeAllViews();
        for (Extra extra : extras) {
            llExtras.addView(new ExtraGroupView(getContext(), extra));
        }
        llExtras.invalidate();

    }
}