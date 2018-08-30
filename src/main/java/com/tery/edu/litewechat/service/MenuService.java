package com.tery.edu.litewechat.service;

import com.github.sd4324530.fastweixin.api.MenuAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.entity.Menu;
import com.github.sd4324530.fastweixin.api.entity.MenuButton;
import com.github.sd4324530.fastweixin.api.enums.MenuType;
import com.github.sd4324530.fastweixin.api.enums.ResultType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by wanglei on 2018/8/30 下午10:25
 **/
@Slf4j
@Service
public class MenuService implements InitializingBean {

    @Autowired
    private ApiConfig config;

    @Override
    public void afterPropertiesSet() throws Exception {
        MenuAPI menuAPI = new MenuAPI(config);
        menuAPI.deleteMenu();

        Menu menu = new Menu();

        MenuButton main1 = new MenuButton();
        main1.setKey("main1");
        main1.setName("去浪吗");
        main1.setType(MenuType.CLICK);

        MenuButton main1_sub1 = new MenuButton();
        main1_sub1.setType(MenuType.CLICK);
        main1_sub1.setName("称骨算命");
        main1_sub1.setKey("main1_sub");

        MenuButton main1_sub2 = new MenuButton();
        main1_sub2.setType(MenuType.CLICK);
        main1_sub2.setName("手纹知命");
        main1_sub2.setKey("main1_sub");

        main1.setSubButton(Arrays.asList(main1_sub1, main1_sub2));

        menu.setButton(Arrays.asList(main1));

        ResultType resultType = menuAPI.createMenu(menu);

        log.info("==>create menu resp:" + resultType.getCode() + "," + resultType.getDescription());
    }


}
