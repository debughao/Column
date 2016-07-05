package com.debughao.column.data.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/7/5 15:39
 * description :
 */
public class TargetPostBean implements Serializable {
    private String titleImage;
    private int last_updated;
    private int likes;
    private int orig_author_id;
    private int id;
    private boolean big_title_image;
    private String title;
    private String snapshot_url;
    private int comments;
    private int column_id;
    private String content;
    private int parent_id;
    private String state;
    private String permission;
    private String vote_type;
    private String copy_permission;
    private String source_url;
    private int url_token;
    private int slug;
    private String publishedTime;
    private int created;
    private String url;
    private String comment_permission;
    /**
     * profileUrl : https://www.zhihu.com/people/dannyw
     * bio :
     * hash : 7088d14b1a166333ae404992b020b20c
     * name : Danny W
     * isOrg : false
     * slug : dannyw
     * avatar : {"id":"323181a6ba04ac967afe33aaeb6735af","template":"https://pic4.zhimg.com/{id}_{size}.jpg"}
     * description : 黄继新半个脑残粉！/ What goes round comes around / Be both sides: Buy side & Sell Side。/ 程浩，天堂是什么样子的？R.I.P
     */

    private AuthorBean author;
    private String summary;
    private String image_url;
    private int member_id;
    private List<Integer> topics;

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public int getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(int last_updated) {
        this.last_updated = last_updated;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getOrig_author_id() {
        return orig_author_id;
    }

    public void setOrig_author_id(int orig_author_id) {
        this.orig_author_id = orig_author_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBig_title_image() {
        return big_title_image;
    }

    public void setBig_title_image(boolean big_title_image) {
        this.big_title_image = big_title_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSnapshot_url() {
        return snapshot_url;
    }

    public void setSnapshot_url(String snapshot_url) {
        this.snapshot_url = snapshot_url;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getColumn_id() {
        return column_id;
    }

    public void setColumn_id(int column_id) {
        this.column_id = column_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getVote_type() {
        return vote_type;
    }

    public void setVote_type(String vote_type) {
        this.vote_type = vote_type;
    }

    public String getCopy_permission() {
        return copy_permission;
    }

    public void setCopy_permission(String copy_permission) {
        this.copy_permission = copy_permission;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public int getUrl_token() {
        return url_token;
    }

    public void setUrl_token(int url_token) {
        this.url_token = url_token;
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

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComment_permission() {
        return comment_permission;
    }

    public void setComment_permission(String comment_permission) {
        this.comment_permission = comment_permission;
    }

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public List<Integer> getTopics() {
        return topics;
    }

    public void setTopics(List<Integer> topics) {
        this.topics = topics;
    }


}
