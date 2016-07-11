package com.debughao.column.commons;

/**
 * Description : 接口API的URL
 * Date   : 2016-6-21 13:19:55
 */
public class Urls {


    public static final int PAZE_SIZE = 10;
    public static final  String fields= "name,url,href,following,avatar,canManage,slug,creator(slug)";
    public static final String HOST = "https://www.zhihu.com";
    public static final String HOSTAPI = "https://zhuanlan.zhihu.com/api";
    public static final String LOGIN = HOST + "/login/phone_num";
    /**
     * 专栏url 方法
     * https://zhuanlan.zhihu.com/api/recommendations/columns?limit=16&offset=0&seed=11
     */

    public static final String RECOMMENDATIONS = HOSTAPI + "/recommendations/columns";
    public static final String RECOMMENDARTICLE = HOSTAPI + "/recommendations/posts";
    public static final String COLUMNDETAIL = HOSTAPI + "/columns";
    /**
     * 专栏文章列表
     * https://zhuanlan.zhihu.com/api/columns/ChefElyn/posts?limit=10&offset=0
     */
    public static final String COLUMNPOSTS = HOSTAPI + "/columns";
    /***
     * https://zhuanlan.zhihu.com/api/posts/19868470?refer=jinrongcainiaoziqiangji
     */
    public static final String POSTEDETAIl = HOSTAPI + "/posts";
    /**
     * https://zhuanlan.zhihu.com/api/posts/20234763/comments?limit=10&offset=10
     */
}
