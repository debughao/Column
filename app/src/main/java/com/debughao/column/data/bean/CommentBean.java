package com.debughao.column.data.bean;

import java.io.Serializable;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/7/5 17:28
 * description :
 */
public class CommentBean  implements Serializable{

    /**
     * content : 棒棒哒
     * liked : false
     * href : /api/posts/20234763/comments/98793588
     * inReplyToCommentId : 0
     * reviewing : false
     * author : {"profileUrl":"https://www.zhihu.com/people/xiaowulu","bio":"小小小前端","hash":"5e79f840032fd9c52bca3f0b3b6101b6","name":"小无路","isOrg":false,"slug":"xiaowulu","avatar":{"id":"e0838313abe37c317fcb3a05699d622c","template":"https://pic1.zhimg.com/{id}_{size}.jpg"},"description":"http://blog.noway.pub"}
     * createdTime : 2015-10-14T00:09:49+08:00
     * featured : false
     * id : 98793588
     * likesCount : 0
     */

    private String content;
    private boolean liked;
    private String href;
    private int inReplyToCommentId;
    private boolean reviewing;
    /**
     * profileUrl : https://www.zhihu.com/people/xiaowulu
     * bio : 小小小前端
     * hash : 5e79f840032fd9c52bca3f0b3b6101b6
     * name : 小无路
     * isOrg : false
     * slug : xiaowulu
     * avatar : {"id":"e0838313abe37c317fcb3a05699d622c","template":"https://pic1.zhimg.com/{id}_{size}.jpg"}
     * description : http://blog.noway.pub
     */

    private AuthorBean author;
    private String createdTime;
    private boolean featured;
    private int id;
    private int likesCount;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getInReplyToCommentId() {
        return inReplyToCommentId;
    }

    public void setInReplyToCommentId(int inReplyToCommentId) {
        this.inReplyToCommentId = inReplyToCommentId;
    }

    public boolean isReviewing() {
        return reviewing;
    }

    public void setReviewing(boolean reviewing) {
        this.reviewing = reviewing;
    }

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }


}
