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
        return titleImage;
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

    public static class LinksBean {
        private String comments;

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }
    }

    public static class AuthorBean {
        private String profileUrl;
        private String bio;
        private String hash;
        private String name;
        private boolean isOrg;
        private String slug;
        /**
         * id : 3d7477bb6f48a7a274a9678dfc357ee8
         * template : https://pic1.zhimg.com/{id}_{size}.png
         */

        private AvatarBean avatar;
        private String description;

        public String getProfileUrl() {
            return profileUrl;
        }

        public void setProfileUrl(String profileUrl) {
            this.profileUrl = profileUrl;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isIsOrg() {
            return isOrg;
        }

        public void setIsOrg(boolean isOrg) {
            this.isOrg = isOrg;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public AvatarBean getAvatar() {
            return avatar;
        }

        public void setAvatar(AvatarBean avatar) {
            this.avatar = avatar;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public static class AvatarBean {
            private String id;
            private String template;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTemplate() {
                return template;
            }

            public void setTemplate(String template) {
                this.template = template;
            }
        }
    }

    public static class MetaBean {
        private Object previous;
        private Object next;

        public Object getPrevious() {
            return previous;
        }

        public void setPrevious(Object previous) {
            this.previous = previous;
        }

        public Object getNext() {
            return next;
        }

        public void setNext(Object next) {
            this.next = next;
        }
    }
}
