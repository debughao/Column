package com.debughao.column.data.bean;

import java.io.Serializable;

/**
 * Author : debguhao
 * Email : 863260364@qq.com
 * Date : 2016/6/23 11:28
 * description : 专栏文章
 */
public class Posts implements Serializable {

    /**
     * isTitleImageFullScreen : false
     * rating : none
     * sourceUrl :
     * publishedTime : 2016-06-18T23:39:21+08:00
     * links : {"comments":"/api/posts/21377914/comments"}
     * author : {"profileUrl":"https://www.zhihu.com/people/tsauliu","bio":"","hash":"f93b632b3a7fd806fd36aa5cdf802ba7","name":"Liu Cao","isOrg":false,"slug":"tsauliu","avatar":{"id":"3d7477bb6f48a7a274a9678dfc357ee8","template":"https://pic1.zhimg.com/{id}_{size}.png"},"description":"博客：www.tsauliu.com 一天：tsauliu.com/live 书单：tsauliu.com/readinglist **Optimized for Chrome / Safari **"}
     * url : /p/21377914
     * title : 帮部门招个全职员工(求扩散)
     * titleImage : https://pic1.zhimg.com/8eace83ebf0f28e9dd37f1675895c0e8_r.jpg
     * summary :
     * content : 222
     * state : published
     * href : /api/posts/21377914
     * meta : {"previous":null,"next":null}
     * commentPermission : anyone
     * snapshotUrl :
     * canComment : false
     * slug : 21377914
     * commentsCount : 48
     * likesCount : 139
     */

    private boolean isTitleImageFullScreen;
    private String rating;
    private String sourceUrl;
    private String publishedTime;
    /**
     * comments : /api/posts/21377914/comments
     */

    private LinksBean links;
    /**
     * profileUrl : https://www.zhihu.com/people/tsauliu
     * bio :
     * hash : f93b632b3a7fd806fd36aa5cdf802ba7
     * name : Liu Cao
     * isOrg : false
     * slug : tsauliu
     * avatar : {"id":"3d7477bb6f48a7a274a9678dfc357ee8","template":"https://pic1.zhimg.com/{id}_{size}.png"}
     * description : 博客：www.tsauliu.com 一天：tsauliu.com/live 书单：tsauliu.com/readinglist **Optimized for Chrome / Safari **
     */

    private AuthorBean author;
    private String url;
    private String title;
    private String titleImage;
    private String summary;
    private String content;
    private String state;
    private String href;
    /**
     * previous : null
     * next : null
     */

    private MetaBean meta;
    private String commentPermission;
    private String snapshotUrl;
    private boolean canComment;
    private int slug;
    private int commentsCount;
    private int likesCount;

    public boolean isIsTitleImageFullScreen() {
        return isTitleImageFullScreen;
    }

    public void setIsTitleImageFullScreen(boolean isTitleImageFullScreen) {
        this.isTitleImageFullScreen = isTitleImageFullScreen;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    public LinksBean getLinks() {
        return links;
    }

    public void setLinks(LinksBean links) {
        this.links = links;
    }

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleImage() {
        return titleImage.replace("_r","_b");
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public String getCommentPermission() {
        return commentPermission;
    }

    public void setCommentPermission(String commentPermission) {
        this.commentPermission = commentPermission;
    }

    public String getSnapshotUrl() {
        return snapshotUrl;
    }

    public void setSnapshotUrl(String snapshotUrl) {
        this.snapshotUrl = snapshotUrl;
    }

    public boolean isCanComment() {
        return canComment;
    }

    public void setCanComment(boolean canComment) {
        this.canComment = canComment;
    }

    public int getSlug() {
        return slug;
    }

    public void setSlug(int slug) {
        this.slug = slug;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

}
