package com.debughao.column.data.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/28 17:01
 * description :
 */
public class PreviousBean implements Serializable {


    /**
     * isTitleImageFullScreen : false
     * rating : none
     * titleImage : https://pic3.zhimg.com/94f9d482ec05abe5160fc9cae3bd643e_r.jpg
     * links : {"comments":"/api/posts/20835434/comments"}
     * topics : [{"url":"https://www.zhihu.com/topic/19603355","id":"19603355","name":"编曲"},{"url":"https://www.zhihu.com/topic/19596119","id":"19596119","name":"作曲"},{"url":"https://www.zhihu.com/topic/19550453","id":"19550453","name":"音乐"}]
     * href : /api/posts/20835434
     * author : {"profileUrl":"https://www.zhihu.com/people/ShikiSuen","bio":"牛奶不加糖； 厨一代宗师。","hash":"669bd058f817cba36a1a6af80ae6423f","name":"孫志貴","isOrg":false,"slug":"ShikiSuen","avatar":{"id":"3cd44033c4dedbba614a2ea34c082b7f","template":"https://pic4.zhimg.com/{id}_{size}.jpg"},"description":"// 我不是台湾人 // 删你评论可能是因为你有论点偏差 // 被我拉黑的通常都是白目 // 我说话的态度取决于对方说话的态度 // 就学问方面有争议时，请拿出做学问的态度 // 我的乐理经验都是我自己研读外文教材所学到的，所述理论均有其依据 // 本科在读音乐生 // 辞客堂数位杂谈专栏副主笔 // 曾志豪粉丝 // ラブライブ音乐厨 // 不参与任何与字形演变有关的问答及讨论 // 大千键盘注音输入法重症成瘾者 // 请自己为自己简繁阅读习惯负责，看不惯请用同文堂自己转换 // 王飞专治脑残果黑，朕专治脑残果厨 //「根源道，視無常為有常、化無量為有量、悟無知為我知，それは我知無知（ガチムチ）でござる。」// 曾用ID：冰海 "}
     * content : 222
     * state : published
     * sourceUrl :
     * commentPermission : anyone
     * canComment : true
     * snapshotUrl :
     * slug : 20835434
     * publishedTime : 2016-05-03T13:54:07+08:00
     * url : /p/20835434
     * title : [漫谈] 曾志豪就器乐法对乐思的回收利用
     * summary : 本文所提及的音乐都可以在这里找到：https://www.youtube.com/watch?v=NYP-rye7LSs在贝多芬和萧邦的时代，诸如奏鸣曲和叙事曲等曲式对具体乐思的回收利用方式多见于转调。然而，若仅有转调的话、也未免太单调。不同于传统奏鸣曲对乐思在转调后的纯粹继承与…
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
     * comments : /api/posts/20835434/comments
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
     * description : // 我不是台湾人 // 删你评论可能是因为你有论点偏差 // 被我拉黑的通常都是白目 // 我说话的态度取决于对方说话的态度 // 就学问方面有争议时，请拿出做学问的态度 // 我的乐理经验都是我自己研读外文教材所学到的，所述理论均有其依据 // 本科在读音乐生 // 辞客堂数位杂谈专栏副主笔 // 曾志豪粉丝 // ラブライブ音乐厨 // 不参与任何与字形演变有关的问答及讨论 // 大千键盘注音输入法重症成瘾者 // 请自己为自己简繁阅读习惯负责，看不惯请用同文堂自己转换 // 王飞专治脑残果黑，朕专治脑残果厨 //「根源道，視無常為有常、化無量為有量、悟無知為我知，それは我知無知（ガチムチ）でござる。」// 曾用ID：冰海
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
     * url : https://www.zhihu.com/topic/19603355
     * id : 19603355
     * name : 编曲
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









}
