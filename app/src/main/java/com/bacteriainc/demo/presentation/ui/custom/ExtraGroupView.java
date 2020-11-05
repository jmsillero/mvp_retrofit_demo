package com.bacteriainc.demo.presentation.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bacteriainc.demo.R;
import com.bacteriainc.demo.data.entity.Extra;
import com.bacteriainc.demo.data.entity.Item;

import java.util.List;

public class ExtraGroupView extends ConstraintLayout {
    private Extra extra;
    private TextView tvTitle;
    private TextView tvDescription;
    private LinearLayout llItems;


    public ExtraGroupView(Context context, Extra extra) {
        super(context);
        this.extra = extra;
        init(null, 0);
    }

    public ExtraGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public ExtraGroupView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        View v = inflate(getContext(), R.layout.extra_group_view, this);

        tvTitle = v.findViewById(R.id.tv_title);
        tvDescription = v.findViewById(R.id.tv_description);
        llItems = v.findViewById(R.id.ll_items);
        initData();
    }

    private void initData() {
        tvTitle.setText(extra.getTitulo());
        tvDescription.setText(extra.getDescripcion());

        // populate all extras items
        List<Item> items = extra.getItems();

        // prevent duplicated items...
        llItems.removeAllViews();
        for (Item item : items) {
            llItems.addView(new ExtraItemView(getContext(), item));
        }
        llItems.invalidate();
    }


}