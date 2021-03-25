package com.xxl.job.admin.controller.request;

import java.io.Serializable;

public class QueryGidParam implements Serializable {

    private String appName;

    public QueryGidParam() {
    }

    public QueryGidParam(String appName) {
        this.appName = appName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
