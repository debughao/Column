package com.debughao.column.data.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author : debguhao
 * Email : 863260364@qq.com
 * Date : 2016/6/23 10:38
 * description :专栏详情
 */
public class ColumnDetail implements Serializable {

    /**
     * followersCount : 36716
     * creator : {"profileUrl":"https://www.zhihu.com/people/elyn","bio":"公众号：tianluo_hhhaze","hash":"7e5dc031fdff1a8b4acae392c88caa8c","name":"elyn","isOrg":false,"slug":"elyn","avatar":{"id":"e87392fff5b311cfbcef366ec2a9ead7","template":"https://pic4.zhimg.com/{id}_{size}.jpg"},"description":"我的菜谱公众号\u201ctianluo_hhhaze\u201d，发发快手早餐、原创菜谱和各种厨房tips。每天的早餐都在instagram贴，id是elynchan  :-)  "}
     * topics : [{"url":"https://www.zhihu.com/topic/19551137","id":"19551137","name":"美食"},{"url":"https://www.zhihu.com/topic/19565602","id":"19565602","name":"早餐"},{"url":"https://www.zhihu.com/topic/19551805","id":"19551805","name":"烹饪"}]
     * activateState : activated
     * href : /api/columns/ChefElyn
     * acceptSubmission : true
     * firstTime : false
     * postTopics : [{"postsCount":7,"id":304,"name":"美食"},{"postsCount":5,"id":532,"name":"烹饪"},{"postsCount":1,"id":4887,"name":"财务"},{"postsCount":2,"id":5140,"name":"早餐"},{"postsCount":2,"id":7720,"name":"菜谱"},{"postsCount":4,"id":8393,"name":"厨房"},{"postsCount":1,"id":9765,"name":"湘菜"},{"postsCount":2,"id":15725,"name":"西餐"},{"postsCount":1,"id":19254,"name":"餐具"},{"postsCount":1,"id":21112,"name":"意面"},{"postsCount":1,"id":33496,"name":"烹饪常识"},{"postsCount":1,"id":152901,"name":"知乎盐 Club"},{"postsCount":1,"id":167731,"name":"第三届知乎盐 Club"},{"postsCount":2,"id":168696,"name":"知乎 Live"}]
     * pendingName :
     * avatar : {"id":"b38440fa9","template":"https://pic2.zhimg.com/{id}_{size}.jpg"}
     * canManage : false
     * description : 写菜谱和介绍餐具厨具的地方，微信公众号：tianluo_hhhaze
     * pendingTopics : []
     * nameCanEditUntil : 0
     * reason :
     * banUntil : 0
     * slug : ChefElyn
     * name : 餐桌、橱柜和厨房
     * url : /ChefElyn
     * intro : 写菜谱和介绍餐具厨具的地方，微信公众号：tian…
     * topicsCanEditUntil : 0
     * activateAuthorRequested : none
     * commentPermission : anyone
     * following : false
     * postsCount : 43
     * canPost : false
     */

    private int followersCount;
    /**
     * profileUrl : https://www.zhihu.com/people/elyn
     * bio : 公众号：tianluo_hhhaze
     * hash : 7e5dc031fdff1a8b4acae392c88caa8c
     * name : elyn
     * isOrg : false
     * slug : elyn
     * avatar : {"id":"e87392fff5b311cfbcef366ec2a9ead7","template":"https://pic4.zhimg.com/{id}_{size}.jpg"}
     * description : 我的菜谱公众号“tianluo_hhhaze”，发发快手早餐、原创菜谱和各种厨房tips。每天的早餐都在instagram贴，id是elynchan  :-)
     */

    private CreatorBean creator;
    private String activateState;
    private String href;
    private boolean acceptSubmission;
    private boolean firstTime;
    private String pendingName;
    /**
     * id : b38440fa9
     * template : https://pic2.zhimg.com/{id}_{size}.jpg
     */

    private AvatarBean avatar;
    private boolean canManage;
    private String description;
    private int nameCanEditUntil;
    private String reason;
    private int banUntil;
    private String slug;
    private String name;
    private String url;
    private String intro;
    private int topicsCanEditUntil;
    private String activateAuthorRequested;
    private String commentPermission;
    private boolean following;
    private int postsCount;
    private boolean canPost;
    /**
     * url : https://www.zhihu.com/topic/19551137
     * id : 19551137
     * name : 美食
     */

    private List<TopicsBean> topics;
    /**
     * postsCount : 7
     * id : 304
     * name : 美食
     */

    private List<PostTopicsBean> postTopics;
    private List<?> pendingTopics;

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public CreatorBean getCreator() {
        return creator;
    }

    public void setCreator(CreatorBean creator) {
        this.creator = creator;
    }

    public String getActivateState() {
        return activateState;
    }

    public void setActivateState(String activateState) {
        this.activateState = activateState;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isAcceptSubmission() {
        return acceptSubmission;
    }

    public void setAcceptSubmission(boolean acceptSubmission) {
        this.acceptSubmission = acceptSubmission;
    }

    public boolean isFirstTime() {
        return firstTime;
    }

    public void setFirstTime(boolean firstTime) {
        this.firstTime = firstTime;
    }

    public String getPendingName() {
        return pendingName;
    }

    public void setPendingName(String pendingName) {
        this.pendingName = pendingName;
    }

    public AvatarBean getAvatar() {
        return avatar;
    }

    public void setAvatar(AvatarBean avatar) {
        this.avatar = avatar;
    }

    public boolean isCanManage() {
        return canManage;
    }

    public void setCanManage(boolean canManage) {
        this.canManage = canManage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNameCanEditUntil() {
        return nameCanEditUntil;
    }

    public void setNameCanEditUntil(int nameCanEditUntil) {
        this.nameCanEditUntil = nameCanEditUntil;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getBanUntil() {
        return banUntil;
    }

    public void setBanUntil(int banUntil) {
        this.banUntil = banUntil;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getTopicsCanEditUntil() {
        return topicsCanEditUntil;
    }

    public void setTopicsCanEditUntil(int topicsCanEditUntil) {
        this.topicsCanEditUntil = topicsCanEditUntil;
    }

    public String getActivateAuthorRequested() {
        return activateAuthorRequested;
    }

    public void setActivateAuthorRequested(String activateAuthorRequested) {
        this.activateAuthorRequested = activateAuthorRequested;
    }

    public String getCommentPermission() {
        return commentPermission;
    }

    public void setCommentPermission(String commentPermission) {
        this.commentPermission = commentPermission;
    }

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(int postsCount) {
        this.postsCount = postsCount;
    }

    public boolean isCanPost() {
        return canPost;
    }

    public void setCanPost(boolean canPost) {
        this.canPost = canPost;
    }

    public List<TopicsBean> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicsBean> topics) {
        this.topics = topics;
    }

    public List<PostTopicsBean> getPostTopics() {
        return postTopics;
    }

    public void setPostTopics(List<PostTopicsBean> postTopics) {
        this.postTopics = postTopics;
    }

    public List<?> getPendingTopics() {
        return pendingTopics;
    }

    public void setPendingTopics(List<?> pendingTopics) {
        this.pendingTopics = pendingTopics;
    }

    public static class CreatorBean {
        private String profileUrl;
        private String bio;
        private String hash;
        private String name;
        private boolean isOrg;
        private String slug;
        /**
         * id : e87392fff5b311cfbcef366ec2a9ead7
         * template : https://pic4.zhimg.com/{id}_{size}.jpg
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
    }

    public static class TopicsBean {
        private String url;
        private String id;
        private String name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class PostTopicsBean {
        private int postsCount;
        private int id;
        private String name;

        public int getPostsCount() {
            return postsCount;
        }

        public void setPostsCount(int postsCount) {
            this.postsCount = postsCount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return "ColumnDetail{" +
                "followersCount=" + followersCount +
                ", creator=" + creator +
                ", activateState='" + activateState + '\'' +
                ", href='" + href + '\'' +
                ", acceptSubmission=" + acceptSubmission +
                ", firstTime=" + firstTime +
                ", pendingName='" + pendingName + '\'' +
                ", avatar=" + avatar +
                ", canManage=" + canManage +
                ", description='" + description + '\'' +
                ", nameCanEditUntil=" + nameCanEditUntil +
                ", reason='" + reason + '\'' +
                ", banUntil=" + banUntil +
                ", slug='" + slug + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", intro='" + intro + '\'' +
                ", topicsCanEditUntil=" + topicsCanEditUntil +
                ", activateAuthorRequested='" + activateAuthorRequested + '\'' +
                ", commentPermission='" + commentPermission + '\'' +
                ", following=" + following +
                ", postsCount=" + postsCount +
                ", canPost=" + canPost +
                ", topics=" + topics +
                ", postTopics=" + postTopics +
                ", pendingTopics=" + pendingTopics +
                '}';
    }
}
