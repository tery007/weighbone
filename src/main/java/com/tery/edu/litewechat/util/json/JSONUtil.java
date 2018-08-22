package com.tery.edu.litewechat.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.Assert;

/**
 * Created by wanglei on 2018/7/22 下午6:35
 **/
public class JSONUtil {

    public static <T> T toBean(JSONObject text, Class<T> clazz) {
        Assert.notNull(text, "text is null");
        Assert.notNull(clazz, "class is null");
        return JSON.parseObject(JSONObject.toJSONString(text), clazz);
    }
}
