package com.codermason.pc.util;

/**
 * Created by slhscs216 on 1/9/2015.
 */
public class CountServer {

    private String server;

    private int count;

    public CountServer(String server, int count) {
        this.count = count;
        this.server = server;
    }

    public String getServer() {
        return this.server;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
