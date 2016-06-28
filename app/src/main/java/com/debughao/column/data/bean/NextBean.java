package com.debughao.column.data.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/28 17:30
 * description :
 */
public class NextBean implements Serializable {

    /**
     * isTitleImageFullScreen : false
     * rating : none
     * titleImage : https://pic4.zhimg.com/cc2f252efd7a202c88da5cdfbe8a96c7_r.png
     * links : {"comments":"/api/posts/20919715/comments"}
     * topics : [{"url":"https://www.zhihu.com/topic/19596119","id":"19596119","name":"作曲"},{"url":"https://www.zhihu.com/topic/19608897","id":"19608897","name":"五线谱"},{"url":"https://www.zhihu.com/topic/19550453","id":"19550453","name":"音乐"}]
     * href : /api/posts/20919715
     * author : {"profileUrl":"https://www.zhihu.com/people/ShikiSuen","bio":"牛奶不加糖； 厨一代宗师。","hash":"669bd058f817cba36a1a6af80ae6423f","name":"孫志貴","isOrg":false,"slug":"ShikiSuen","avatar":{"id":"3cd44033c4dedbba614a2ea34c082b7f","template":"https://pic4.zhimg.com/{id}_{size}.jpg"},"description":"df  d f "}
     * content : fdf df
     * state : published
     * sourceUrl :
     * commentPermission : anyone
     * canComment : true
     * snapshotUrl :
     * slug : 20919715
     * publishedTime : 2016-05-18T02:11:25+08:00
     * url : /p/20919715
     * title : Steinberg Dorico 预计今年第四季度问世
     * summary : sfs f
     * column : {"slug":"ongakuriron","name":"【辞客堂】曲创杂谈版"}
     * meta : {"previous":null,"next":null}
     * reviewingCommentsCount : 0
     * commentsCount : 0
     * likesCount : 0
     */

    private boolean isTitleImageFullScreen;
    private String rating;
    private String titleImage;
    /**
     * comments : /api/posts/20919715/comments
     */

    private LinksBean links;
    private String href;
    /**
     * profileUrl : https://www.zhihu.com/people/ShikiSuen
     * bio : 牛奶不加糖； 厨一代宗师。
     * hash : 669bd058f817cba36a1a6af80ae6423f
     * name : 孫志貴
     * isOrg : false
     * slug : ShikiSuen
     * avatar : {"id":"3cd44033c4dedbba614a2ea34c082b7f","template":"https://pic4.zhimg.com/{id}_{size}.jpg"}
     * description : df  d f
     */

    private AuthorBean author;
    private String content;
    private String state;
    private String sourceUrl;
    private String commentPermission;
    private boolean canComment;
    private String snapshotUrl;
    private int slug;
    private String publishedTime;
    private String url;
    private String title;
    private String summary;
    /**
     * slug : ongakuriron
     * name : 【辞客堂】曲创杂谈版
     */

    private ColumnBean columnBean;
    /**
     * previous : null
     * next : null
     */

    private MetaBean meta;
    private int reviewingCommentsCount;
    private int commentsCount;
    private int likesCount;
    /**
     * url : https://www.zhihu.com/topic/19596119
     * id : 19596119
     * name : 作曲
     */

    private List<TopicsBean> topics;

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

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public LinksBean getLinks() {
        return links;
    }

    public void setLinks(LinksBean links) {
        this.links = links;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
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

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getCommentPermission() {
        return commentPermission;
    }

    public void setCommentPermission(String commentPermission) {
        this.commentPermission = commentPermission;
    }

    public boolean isCanComment() {
        return canComment;
    }

    public void setCanComment(boolean canComment) {
        this.canComment = canComment;
    }

    public String getSnapshotUrl() {
        return snapshotUrl;
    }

    public void setSnapshotUrl(String snapshotUrl) {
        this.snapshotUrl = snapshotUrl;
    }

    public int getSlug() {
        return slug;
    }

    public void setSlug(int slug) {
        this.slug = slug;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ColumnBean getColumnBean() {
        return columnBean;
    }

    public void setColumnBean(ColumnBean columnBean) {
        this.columnBean = columnBean;
    }

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public int getReviewingCommentsCount() {
        return reviewingCommentsCount;
    }

    public void setReviewingCommentsCount(int reviewingCommentsCount) {
        this.reviewingCommentsCount = reviewingCommentsCount;
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

    public List<TopicsBean> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicsBean> topics) {
        this.topics = topics;
    }

    public static class LinksBean {
        private String comments;

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }
    }


}
