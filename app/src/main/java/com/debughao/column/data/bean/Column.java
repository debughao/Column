package com.debughao.column.data.bean;

import java.io.Serializable;

/**
 * Created by admin on 2016/6/22.
 */
public class Column implements Serializable {

    /**
     * followersCount : 18641
     * name : 止水
     * url : /stillwater
     * postsCount : 36
     * description : 本专栏欢迎来自风险投资、互联网和金融科技产业、金融市场等方面的投稿，致力于为读者提供金融和投资领域的实用知识和最新故事。
     * slug : stillwater
     * avatar : {"id":"b4f67e26e","template":"https://pic3.zhimg.com/{id}_{size}.jpg"}
     */

    private int followersCount;
    private String name;
    private String url;
    private int postsCount;
    private String description;
    private String slug;
    /**
     * id : b4f67e26e
     * template : https://pic3.zhimg.com/{id}_{size}.jpg
     */

    private AvatarBean avatar;

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(int postsCount) {
        this.postsCount = postsCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
            return template.replace("{id}",id).replace("{size}","b");
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        @Override
        public String toString() {
            return "AvatarBean{" +
                    "id='" + id + '\'' +
                    ", template='" + template.replace("{id}",id).replace("{size}","b") + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Column{" +
                "followersCount=" + followersCount +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", postsCount=" + postsCount +
                ", description='" + description + '\'' +
                ", slug='" + slug + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}
