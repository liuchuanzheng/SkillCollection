package com.liuchuanzheng.skillcollection.bean;

/**
 * Created by 刘传政 on 2017/8/28 0028.
 * QQ:1052374416
 * 电话:18501231486
 * 作用:eventbus 的发送事件类
 * 注意事项:
 */

public class MessageEvent {
    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
