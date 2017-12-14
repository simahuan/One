package com.komoriwu.one.all.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.FZTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-12-14.
 */

public class FindHotSortAdapter extends RecyclerView.Adapter<FindHotSortAdapter.FindHotSortViewHolder> {
    private Context mContext;
    private List<FindBean.ItemListBeanX> mItemList;

    public FindHotSortAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setHotSortData(List<FindBean.ItemListBeanX> mItemList) {
        this.mItemList = new ArrayList<>();
        for (FindBean.ItemListBeanX itemListBeanX : mItemList) {
            if (itemListBeanX.getType().equals(Constants.BRIEF_CARD)) {
                this.mItemList.add(itemListBeanX);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public FindHotSortViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_brief_card, parent,
                false);
        return new FindHotSortViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FindHotSortViewHolder holder, int position) {
        FindBean.ItemListBeanX itemListBean = mItemList.get(position);
        Utils.displayImage(mContext, itemListBean.getData().getIcon(), holder.ivCover);
        holder.tvTitle.setText(itemListBean.getData().getTitle());
        holder.tvDescription.setText(itemListBean.getData().getDescription());
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    class FindHotSortViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_cover)
        ImageView ivCover;
        @BindView(R.id.tv_title)
        FZTextView tvTitle;
        @BindView(R.id.tv_description)
        FZTextView tvDescription;

        public FindHotSortViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
