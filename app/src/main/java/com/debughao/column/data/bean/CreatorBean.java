package com.debughao.column.data.bean;

import java.io.Serializable;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/24 09:54
 * description :
 */
public class CreatorBean implements Serializable {
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


}
