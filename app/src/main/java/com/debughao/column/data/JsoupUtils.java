package com.debughao.column.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by admin on 2016/6/21.
 */
public class JsoupUtils {
    public  static  String getXrsf(String str){
        Document doc = Jsoup.parseBodyFragment(str);
        Element body = doc.body();
        String  xrsf = body.select("input[name=_xsrf]").get(0).val();
        return xrsf;
    }
}
