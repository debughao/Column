package com.debughao.column;

import android.app.Activity;
import android.app.Application;

import com.debughao.column.nohttp.CallServer;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/6/21.
 */
public class App extends Application{
    private static App mInstance;
    public static final String PREFERENCE_NAME = "_zhiHuColumn";
    private List<Activity> mActivities = new ArrayList<Activity>();
    public static App getInstance() {
        return mInstance;

    }
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
        //初始化nohttp
        NoHttp.initialize(this);
        Logger.setTag("zhihuzhanlan");
        Logger.setDebug(false);
        com.orhanobut.logger.Logger.init("zhihuColumn");
    }




    /**
     * 把Activity加入历史堆栈
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        mActivities.add(activity);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for (Activity activity : mActivities) {
            activity.finish();
        }
        // 程序退出时取消所有请求
        CallServer.getRequestInstance().cancelAll();
        // 程序退出时停止请求队列，如果这里的NoHttpRequestQueue是单例模式，NoHttp所在的进程没杀死而停止了队列，会导致再打开app不能请求网络
        CallServer.getRequestInstance().stopAll();
        System.exit(0);
    }
}
