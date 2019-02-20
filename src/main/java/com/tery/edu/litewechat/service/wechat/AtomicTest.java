package com.tery.edu.litewechat.service.wechat;

/**
 * @Description
 * @Author wanglei
 * @Date Created on 2018/12/22 下午5:16
 **/
public class AtomicTest {

    private volatile Integer count;

    public void increace() {
        count++;
    }
}
