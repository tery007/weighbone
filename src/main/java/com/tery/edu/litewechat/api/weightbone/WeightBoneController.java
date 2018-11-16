package com.tery.edu.litewechat.api.weightbone;

import com.tery.edu.litewechat.domain.weightBone.BoneInfo;
import com.tery.edu.litewechat.domain.weightBone.UserReq;
import com.tery.edu.litewechat.service.user.WeightBoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wanglei on 2018/10/18 上午9:52
 **/
@Slf4j
@Controller
@RequestMapping(value = "/weight")
public class WeightBoneController {

    @Autowired
    private WeightBoneService weightBoneService;

    /**
     * 点击"称骨"进入，初始化页面
     * @param map
     * @return
     */
    @RequestMapping(value = "/index.html",method = RequestMethod.GET)
    public String index(ModelMap map) {
        UserReq userReq =weightBoneService.initUserReq();
        map.put("userReq", userReq);
        return "weightBone2";
    }

    @RequestMapping(value = "/weightBone")
    public ModelAndView weightBone(UserReq userReq) {
        try {
            BoneInfo boneInfo=weightBoneService.weightBone(userReq);
            return new ModelAndView("weightBone", "boneInfo", boneInfo);
        } catch (Exception e) {
            log.error("weightBone fail:" + e);
            return null;
        }
    }
}
