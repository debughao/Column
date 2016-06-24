package com.debughao.column.data.bean;

import java.io.Serializable;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/6/24 09:53
 * description :
 */
public class AvatarBean implements Serializable {
    private String id;
    private String template;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemplate() {
        return template.replace("{id}", id).replace("{size}", "b");
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public String toString() {
        return "AvatarBean{" +
                "id='" + id + '\'' +
                ", template='" + template.replace("{id}", id).replace("{size}", "b") + '\'' +
                '}';
    }
}
