package com.debughao.column.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.debughao.column.R;
import com.debughao.column.data.bean.Column;

import java.util.List;

/**
 *
 */
public class ColumnAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    private List<Column> mData;
    private boolean mShowFooter = true;
    private Context mContext;

    private OnItemClickListener mOnItemClickListener;

    public ColumnAdapter(Context context , List<Column> ColumnList) {
        this.mContext = context;
        this.mData= ColumnList;
    }

    public void setmDate(List<Column> data) {
        this.mData = data;
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        // 最后一个item设置为footerView
        if (!mShowFooter) {
            return TYPE_ITEM;
        }
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_column, parent, false);
            ItemViewHolder vh = new ItemViewHolder(v);
            return vh;
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.footer, null);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            return new FooterViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            Column Column = mData.get(position);
            if (Column == null) {
                return;
            }
            ((ItemViewHolder) holder).mTitle.setText(Column.getName());
            ((ItemViewHolder) holder).mDesc.setText(Column.getDescription());
            ((ItemViewHolder) holder).mPostsCount.setText(Column.getPostsCount()+" 篇文章");
            ((ItemViewHolder) holder).mFollowersCount.setText(""+ Column.getFollowersCount()+" 人关注");
            Glide.with(mContext).load(Column.getAvatar().getTemplate("m")).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(((ItemViewHolder) holder).mNewsImg);
        }
    }

    @Override
    public int getItemCount() {
        int begin = mShowFooter ? 1 : 0;
        if (mData == null) {
            return begin;
        }
        return mData.size() + begin;
    }

    public Column getItem(int position) {
        return mData == null ? null : mData.get(position);
    }

    public void isShowFooter(boolean showFooter) {
        this.mShowFooter = showFooter;
    }

    public boolean isShowFooter() {
        return this.mShowFooter;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View view) {
            super(view);
        }

    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTitle;
        public TextView mDesc;
        public ImageView mNewsImg;
        public TextView mFollowersCount;
        public TextView mPostsCount;

        public ItemViewHolder(View v) {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.tv_item_columnTitle);
            mDesc = (TextView) v.findViewById(R.id.tv_item_columneDscription);
            mNewsImg = (ImageView) v.findViewById(R.id.iv_item_columnAvatar);
            mFollowersCount = (TextView) v.findViewById(R.id.tv_item_columnFollowersCount);
            mPostsCount = (TextView) v.findViewById(R.id.tv_item_columnPostsCount);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(view, this.getLayoutPosition());
            }
        }
    }

}
