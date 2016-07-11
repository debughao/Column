package com.debughao.column.data.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/7/11 21:10
 * description :
 */
public class RecommendPostsBean implements Serializable {


    /**
     * titleImage : https://pic4.zhimg.com/b99eab5fd300a3c131e35cea8f9fef17_r.jpg
     * last_updated : 1464832845
     * topics : [5906,152738,8040]
     * likes : 0
     * orig_author_id : 0
     * id : 698302
     * big_title_image : false
     * title : 这才是范加尔在曼联失败的根本原因—曼联更衣室秘辛
     * snapshot_url :
     * comments : 0
     * column_id : 8482
     * content : fs fs f
     * parent_id : 0
     * state : ARTICLE_PUBLISHED
     * reviewing_comments : null
     * permission : ARTICLE_PUBLIC
     * vote_type : ARTICLE_VOTE_CLEAR
     * copy_permission : ARTICLE_COPYABLE
     * source_url :
     * url_token : 21286438
     * slug : 21286438
     * publishedTime : 2016-06-02T09:56:55+08:00
     * created : 1464832615
     * url : /p/21286438
     * comment_permission : ARTICLE_ALL_CAN_COMMENT
     * author : {"profileUrl":"https://www.zhihu.com/people/suang","bio":"畅快爱曼联，干货写曼联。微信公众号：三无青年爱曼联","hash":"10ad75add55c54afad66e337ce7503ac","name":"苏爽爽","isOrg":false,"slug":"suang","avatar":{"id":"a5dfacc6cd53af65f98b81fcb9c73fc2","template":"https://pic3.zhimg.com/{id}_{size}.jpg"},"description":"尊重理性，尊重真实。爱曼联，写曼联，畅快，干货。"}
     * summary : 译文原作者：马克-奥登（Oden）发表于《独立报》文中的引言，均是博主加的，非原文范加尔在曼联第二年走到了尽头。有人说范加尔在曼联的失败是因为伤病，有人说是因为古板，有人说战术不适应英超……职业足球里，一位成功的主教练带出一支成功的球队，成功…
     * column : {"last_updated":1459508571,"contribute_permission":"COLUMN_PUBLIC","can_manage":true,"intro":"尊重理性，尊重真实，这里只有曼联，畅快，干货","id":8482,"description":"别走，这里有爱曼联的理由，这会是曼联最好的战术球评专栏，畅快，干货，公众号：三无青年爱曼联","title":"老特拉福德常驻记者","can_post":true,"state":"COLUMN_NORMAL","followers":0,"activate_author_requested":false,"image_path":"07f09bf18587be8d73930415e96cd509.jpeg","permission":"COLUMN_PUBLIC","url_token":"ManUtd","slug":"ManUtd","articles_count":0,"name":"老特拉福德常驻记者","created":1446722235,"url":"http://zhuanlan.zhihu.com/ManUtd","comment_permission":"COLUMN_ALL_CAN_COMMENT","image_url":"https://pic2.zhimg.com/07f09bf18587be8d73930415e96cd509_l.jpeg","member_id":98218,"following":false}
     * image_url : https://pic4.zhimg.com/b99eab5fd300a3c131e35cea8f9fef17_r.jpg
     * member_id : 98218
     */

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
    private Object reviewing_comments;
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
     * profileUrl : https://www.zhihu.com/people/suang
     * bio : 畅快爱曼联，干货写曼联。微信公众号：三无青年爱曼联
     * hash : 10ad75add55c54afad66e337ce7503ac
     * name : 苏爽爽
     * isOrg : false
     * slug : suang
     * avatar : {"id":"a5dfacc6cd53af65f98b81fcb9c73fc2","template":"https://pic3.zhimg.com/{id}_{size}.jpg"}
     * description : 尊重理性，尊重真实。爱曼联，写曼联，畅快，干货。
     */

    private AuthorBean author;
    private String summary;
    /**
     * last_updated : 1459508571
     * contribute_permission : COLUMN_PUBLIC
     * can_manage : true
     * intro : 尊重理性，尊重真实，这里只有曼联，畅快，干货
     * id : 8482
     * description : 别走，这里有爱曼联的理由，这会是曼联最好的战术球评专栏，畅快，干货，公众号：三无青年爱曼联
     * title : 老特拉福德常驻记者
     * can_post : true
     * state : COLUMN_NORMAL
     * followers : 0
     * activate_author_requested : false
     * image_path : 07f09bf18587be8d73930415e96cd509.jpeg
     * permission : COLUMN_PUBLIC
     * url_token : ManUtd
     * slug : ManUtd
     * articles_count : 0
     * name : 老特拉福德常驻记者
     * created : 1446722235
     * url : http://zhuanlan.zhihu.com/ManUtd
     * comment_permission : COLUMN_ALL_CAN_COMMENT
     * image_url : https://pic2.zhimg.com/07f09bf18587be8d73930415e96cd509_l.jpeg
     * member_id : 98218
     * following : false
     */

    private ColumnBean column;
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

    public Object getReviewing_comments() {
        return reviewing_comments;
    }

    public void setReviewing_comments(Object reviewing_comments) {
        this.reviewing_comments = reviewing_comments;
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

    public ColumnBean getColumn() {
        return column;
    }

    public void setColumn(ColumnBean column) {
        this.column = column;
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



    public static class ColumnBean {
        private int last_updated;
        private String contribute_permission;
        private boolean can_manage;
        private String intro;
        private int id;
        private String description;
        private String title;
        private boolean can_post;
        private String state;
        private int followers;
        private boolean activate_author_requested;
        private String image_path;
        private String permission;
        private String url_token;
        private String slug;
        private int articles_count;
        private String name;
        private int created;
        private String url;
        private String comment_permission;
        private String image_url;
        private int member_id;
        private boolean following;

        public int getLast_updated() {
            return last_updated;
        }

        public void setLast_updated(int last_updated) {
            this.last_updated = last_updated;
        }

        public String getContribute_permission() {
            return contribute_permission;
        }

        public void setContribute_permission(String contribute_permission) {
            this.contribute_permission = contribute_permission;
        }

        public boolean isCan_manage() {
            return can_manage;
        }

        public void setCan_manage(boolean can_manage) {
            this.can_manage = can_manage;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isCan_post() {
            return can_post;
        }

        public void setCan_post(boolean can_post) {
            this.can_post = can_post;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getFollowers() {
            return followers;
        }

        public void setFollowers(int followers) {
            this.followers = followers;
        }

        public boolean isActivate_author_requested() {
            return activate_author_requested;
        }

        public void setActivate_author_requested(boolean activate_author_requested) {
            this.activate_author_requested = activate_author_requested;
        }

        public String getImage_path() {
            return image_path;
        }

        public void setImage_path(String image_path) {
            this.image_path = image_path;
        }

        public String getPermission() {
            return permission;
        }

        public void setPermission(String permission) {
            this.permission = permission;
        }

        public String getUrl_token() {
            return url_token;
        }

        public void setUrl_token(String url_token) {
            this.url_token = url_token;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public int getArticles_count() {
            return articles_count;
        }

        public void setArticles_count(int articles_count) {
            this.articles_count = articles_count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public boolean isFollowing() {
            return following;
        }

        public void setFollowing(boolean following) {
            this.following = following;
        }
    }
}
