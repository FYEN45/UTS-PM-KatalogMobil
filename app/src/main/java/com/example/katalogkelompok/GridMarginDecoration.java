package com.example.katalogkelompok;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridMarginDecoration extends RecyclerView.ItemDecoration{
    private final int left;
    private final int right;
    private final int top;
    private final int bottom;

    public GridMarginDecoration(int left, int right, int top, int bottom){
        this.left = left;
        this.right =right;
        this.top = top;
        this.bottom = bottom;
    }

    @Override
    public void getItemOffsets(Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state){
        outRect.set(left, right, top, bottom);
    }
}
