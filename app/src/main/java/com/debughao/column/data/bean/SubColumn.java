package com.debughao.column.data.bean;

import java.io.Serializable;

/**
 * Author : debughao
 * Email : 863260364@qq.com
 * Date : 2016/7/5 14:31
 * description :
 */
public class SubColumn implements Serializable {

    /**
     * last_updated : 1375869747
     * contribute_permission : COLUMN_PUBLIC
     * can_manage : true
     * intro : Be both sides: Buy side …
     * id : 266
     * description : Be both sides: Buy side & Sell side What Goes round, comes around …… 金融的自留地。文章，观点，数据，策略，分析的综合。 At the end, everyone's delta goes to ZERO ……
     * title : Dynamic Delta - Pure Alpha
     * can_post : true
     * state : COLUMN_NORMAL
     * followers : 0
     * activate_author_requested : false
     * image_path : bf08d9b2c
     * permission : COLUMN_PRIVATE
     * url_token : delta
     * slug : delta
     * articles_count : 0
     * name : Dynamic Delta - Pure Alpha
     * created : 1375780690
     * url : http://zhuanlan.zhihu.com/delta
     * comment_permission : COLUMN_ALL_CAN_COMMENT
     * image_url : https://pic1.zhimg.com/bf08d9b2c_l.jpg
     * avatar : {"id":"bf08d9b2c","template":"https://pic1.zhimg.com/{id}_{size}.jpg"}
     * member_id : 445617
     * following : false
     */

    private SourceColumnBean sourceColumn;
    /**
     * sourceColumn : {"last_updated":1375869747,"contribute_permission":"COLUMN_PUBLIC","can_manage":true,"intro":"Be both sides: Buy side \u2026","id":266,"description":"Be both sides: Buy side & Sell side What Goes round, comes around \u2026\u2026 金融的自留地。文章，观点，数据，策略，分析的综合。 At the end, everyone's delta goes to ZERO \u2026\u2026","title":"Dynamic Delta - Pure Alpha","can_post":true,"state":"COLUMN_NORMAL","followers":0,"activate_author_requested":false,"image_path":"bf08d9b2c","permission":"COLUMN_PRIVATE","url_token":"delta","slug":"delta","articles_count":0,"name":"Dynamic Delta - Pure Alpha","created":1375780690,"url":"http://zhuanlan.zhihu.com/delta","comment_permission":"COLUMN_ALL_CAN_COMMENT","image_url":"https://pic1.zhimg.com/bf08d9b2c_l.jpg","avatar":{"id":"bf08d9b2c","template":"https://pic1.zhimg.com/{id}_{size}.jpg"},"member_id":445617,"following":false}
     * state : accepted
     * targetPost : {"titleImage":"https://pic1.zhimg.com/6491550d96e294ce9beadc627cc6c300_r.jpg","last_updated":1462858248,"topics":[6839,19800],"likes":0,"orig_author_id":0,"id":532664,"big_title_image":true,"title":"Sohn Conference 2016 上","snapshot_url":"","comments":0,"column_id":266,"content":"原来因为太懒了根本没有想动笔，可是连续看了好几个公众账号说了一下今年的Sohn的Idea，不仅漏了好多内容有的根本写的就不对，所以决定还是自己写一份","parent_id":0,"state":"ARTICLE_PUBLISHED","permission":"ARTICLE_PUBLIC","vote_type":"ARTICLE_VOTE_CLEAR","copy_permission":"ARTICLE_COPYABLE","source_url":"","url_token":20874580,"slug":20874580,"publishedTime":"2016-05-10T13:29:52+08:00","created":1462858192,"url":"/p/20874580","comment_permission":"ARTICLE_NOBODY_CAN_COMMENT","author":{"profileUrl":"https://www.zhihu.com/people/dannyw","bio":"","hash":"7088d14b1a166333ae404992b020b20c","name":"Danny W","isOrg":false,"slug":"dannyw","avatar":{"id":"323181a6ba04ac967afe33aaeb6735af","template":"https://pic4.zhimg.com/{id}_{size}.jpg"},"description":"黄继新半个脑残粉！/ What goes round comes around / Be both sides: Buy side & Sell Side。/ 程浩，天堂是什么样子的？R.I.P"},"summary":"原来因为太懒了根本没有想动笔，可是连续看了好几个公众账号说了一下今年的Sohn的Idea，不仅漏了好多内容有的根本写的就不对，所以决定还是自己写一份","image_url":"https://pic1.zhimg.com/6491550d96e294ce9beadc627cc6c300_r.jpg","member_id":445617}
     * id : 359832
     */

    private String state;
    /**
     * titleImage : https://pic1.zhimg.com/6491550d96e294ce9beadc627cc6c300_r.jpg
     * last_updated : 1462858248
     * topics : [6839,19800]
     * likes : 0
     * orig_author_id : 0
     * id : 532664
     * big_title_image : true
     * title : Sohn Conference 2016 上
     * snapshot_url :
     * comments : 0
     * column_id : 266
     * content : 原来因为太懒了根本没有想动笔，可是连续看了好几个公众账号说了一下今年的Sohn的Idea，不仅漏了好多内容有的根本写的就不对，所以决定还是自己写一份
     * parent_id : 0
     * state : ARTICLE_PUBLISHED
     * permission : ARTICLE_PUBLIC
     * vote_type : ARTICLE_VOTE_CLEAR
     * copy_permission : ARTICLE_COPYABLE
     * source_url :
     * url_token : 20874580
     * slug : 20874580
     * publishedTime : 2016-05-10T13:29:52+08:00
     * created : 1462858192
     * url : /p/20874580
     * comment_permission : ARTICLE_NOBODY_CAN_COMMENT
     * author : {"profileUrl":"https://www.zhihu.com/people/dannyw","bio":"","hash":"7088d14b1a166333ae404992b020b20c","name":"Danny W","isOrg":false,"slug":"dannyw","avatar":{"id":"323181a6ba04ac967afe33aaeb6735af","template":"https://pic4.zhimg.com/{id}_{size}.jpg"},"description":"黄继新半个脑残粉！/ What goes round comes around / Be both sides: Buy side & Sell Side。/ 程浩，天堂是什么样子的？R.I.P"}
     * summary : 原来因为太懒了根本没有想动笔，可是连续看了好几个公众账号说了一下今年的Sohn的Idea，不仅漏了好多内容有的根本写的就不对，所以决定还是自己写一份
     * image_url : https://pic1.zhimg.com/6491550d96e294ce9beadc627cc6c300_r.jpg
     * member_id : 445617
     */

    private TargetPostBean targetPost;
    private int id;

    public SourceColumnBean getSourceColumn() {
        return sourceColumn;
    }

    public void setSourceColumn(SourceColumnBean sourceColumn) {
        this.sourceColumn = sourceColumn;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public TargetPostBean getTargetPost() {
        return targetPost;
    }

    public void setTargetPost(TargetPostBean targetPost) {
        this.targetPost = targetPost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
