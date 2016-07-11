package com.debughao.column.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.debughao.column.R;
import com.debughao.column.data.bean.CommentBean;
import com.debughao.column.utils.DateHelper;
import com.debughao.column.widget.view.CircleImageView;

import java.util.List;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/7/5 17:30
 * description :
 */
public class CommentAdapter extends BaseAdapter {
  private   List<CommentBean> mCommentList;
    public Context mContext;
    public LayoutInflater mLayoutInflater;
    private ViewHolder mHolder;

    public CommentAdapter(List<CommentBean> mCommentList, Context context) {
        this.mCommentList = mCommentList;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mCommentList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            mHolder = new ViewHolder();
                convertView = mLayoutInflater.inflate(R.layout.item_posts_comment, null);
            mHolder.mCommenterAvatar= (CircleImageView) convertView.findViewById(R.id.iv_postsCommentAvatars);
            mHolder.mCommenterName= (TextView) convertView.findViewById(R.id.tv_PostsCommentName);
            mHolder.mCommentContent= (TextView) convertView.findViewById(R.id.tv_PostsCommentContent);
            mHolder.mCommentDate= (TextView) convertView.findViewById(R.id.tv_commentDate);
            mHolder.mCommentReply= (TextView) convertView.findViewById(R.id.tv_commentReply);
            mHolder.mCommentReport= (TextView) convertView.findViewById(R.id.tv_commentReport);
            mHolder.mCommentCheck= (TextView) convertView.findViewById(R.id.tv_checkComment);
            mHolder.mCommentLikeNum= (TextView) convertView.findViewById(R.id.tv_commentLikeNum);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }
        String CommenterName=mCommentList.get(i).getAuthor().getName();
        int likesCount=mCommentList.get(i).getLikesCount();
        mHolder.mCommenterName.setText(CommenterName);
        mHolder.mCommentContent.setText( mCommentList.get(i).getContent());
        String commentTime=mCommentList.get(i).getCreatedTime();
        mHolder.mCommentDate.setText(DateHelper.getInstance().getTimeStateString(commentTime));
        Glide.with(mContext).load(mCommentList.get(i).getAuthor().getAvatar().getTemplate("m")).diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.mCommenterAvatar);
        if (likesCount!=0){
            mHolder.mCommentLikeNum.setText(likesCount+" 赞");
            mHolder.mCommentLikeNum.setVisibility(View.VISIBLE);
        }else {
            mHolder.mCommentLikeNum.setVisibility(View.GONE);
        }
        return convertView;
    }

    private class ViewHolder {
        CircleImageView  mCommenterAvatar;
        TextView mCommenterName;
        TextView mCommentContent;
        TextView mCommentDate;
        TextView mCommentReply;
        TextView mCommentReport;
        TextView mCommentCheck;
        TextView mCommentLikeNum;
    }
}
