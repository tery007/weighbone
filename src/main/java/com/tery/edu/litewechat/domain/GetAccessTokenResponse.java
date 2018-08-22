package com.tery.edu.litewechat.domain;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by wanglei on 2018/7/14 下午10:39
 **/
@Getter
@Setter
@ToString(callSuper = true)
public class GetAccessTokenResponse {

    @JSONField(name = "access_token")
    private String accessToken;

    @JSONField(name = "expires_in")
    private Integer expiresIn;

    @JSONField(name = "errcode")
    private String errcode;

    @JSONField(name = "errmsg")
    private String errmsg;
}
