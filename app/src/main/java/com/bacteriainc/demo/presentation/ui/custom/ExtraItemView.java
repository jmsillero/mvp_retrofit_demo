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
import com.bacteriainc.demo.data.entity.Extra;
import com.bacteriainc.demo.data.entity.Item;

public class ExtraItemView extends ConstraintLayout {
    private Item item;
    TextView tvName;
    TextView tvPrice;

    public ExtraItemView(Context context, Item item) {
        super(context);
        this.item = item;
        init(null, 0);
    }

    public ExtraItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public ExtraItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        View v = inflate(getContext(), R.layout.extra_item_view, this);

        tvName = v.findViewById(R.id.tv_name);
        tvPrice = v.findViewById(R.id.tv_price);

        initData();
    }

    @SuppressLint("SetTextI18n")
    private void initData() {
        tvName.setText(item.getNombre());
        tvPrice.setText(Double.toString(item.getPrecio()));
    }


}