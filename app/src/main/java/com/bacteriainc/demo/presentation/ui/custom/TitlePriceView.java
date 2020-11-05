package com.bacteriainc.demo.presentation.ui.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bacteriainc.demo.R;
import com.bacteriainc.demo.data.entity.Price;


public class TitlePriceView extends ConstraintLayout {
    private Price price;

    private TextView tvTitle;
    private TextView tvPrice;


    public TitlePriceView(Context context, Price price) {
        super(context);
        this.price = price;
        init(null, 0);
    }

    public TitlePriceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public TitlePriceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    @SuppressLint("SetTextI18n")
    private void setupValues() {
        tvTitle.setText(this.price.getTitulo());
        tvPrice.setText(Double.toString(this.price.getPrecio()));
    }

    private void init(AttributeSet attrs, int defStyle) {
        View v = inflate(getContext(), R.layout.title_price_view, this);
        tvTitle = v.findViewById(R.id.tv_title);
        tvPrice = v.findViewById(R.id.tv_price);

    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
        setupValues();
    }
}