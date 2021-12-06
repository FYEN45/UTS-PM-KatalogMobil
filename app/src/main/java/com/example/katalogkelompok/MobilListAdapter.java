package com.example.katalogkelompok;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MobilListAdapter extends RecyclerView.Adapter<MobilListAdapter.MobilViewHolder> {
    private final List<Mobil> mobilList;
    private final OnGridItemSelectedListener onGridItemSelectedListener;

    public MobilListAdapter(OnGridItemSelectedListener onGridItemSelectedListener) {
        this.onGridItemSelectedListener = onGridItemSelectedListener;
        mobilList = new ArrayList<>();
    }

    private void add(Mobil item) {
        mobilList.add(item);
        notifyItemInserted(mobilList.size() - 1);
    }

    public void addAll(List<Mobil> mobilList) {
        for (Mobil mobil : mobilList) {
            add(mobil);
        }
    }

    public Mobil getItem(int position) {
        return mobilList.get(position);
    }

    @NonNull
    @Override
    public MobilListAdapter.MobilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_mobil, parent, false);
        final MobilViewHolder mobilViewHolder = new MobilViewHolder(view);
        mobilViewHolder.itemView.setOnClickListener(v -> {
            int adapterPos = mobilViewHolder.getAdapterPosition();
            if (adapterPos != RecyclerView.NO_POSITION) {
                if (onGridItemSelectedListener != null) {
                    onGridItemSelectedListener.onGridItemClick(mobilViewHolder.itemView, adapterPos);
                }
            }
        });
        return mobilViewHolder;
    }

    @Override
    public void onBindViewHolder(MobilListAdapter.MobilViewHolder holder, int position) {
        final Mobil single = mobilList.get(position);
        holder.img.setImageResource(single.getImg());
        holder.title.setText(single.getTitle());
    }

    @Override
    public int getItemCount() {
        return mobilList.size();
    }

    public static class MobilViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView title;

        public MobilViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
        }
    }

    public interface OnGridItemSelectedListener {
        void onGridItemClick(View view, int position);
    }
}
