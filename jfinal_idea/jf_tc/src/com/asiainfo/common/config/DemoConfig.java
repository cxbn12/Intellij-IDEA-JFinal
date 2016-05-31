package com.asiainfo.common.config;

import com.asiainfo.controller.BlogController;
import com.asiainfo.controller.IndexController;
import com.asiainfo.model.Blog;
import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

/**
 * com.asiainfo.common.config
 * jfinal_ideaa
 * Created by nixinsheng on 2016/5/31 0031.
 */
public class DemoConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants me) {
        /**
         * 1.加载配置文件
         * 2.设置视图模板的类型
         * 3.设置视图模板的基本路径
         */
        PropKit.use("config.properties");
        me.setViewType(ViewType.JSP);
        me.setBaseViewPath("/view");
        me.setDevMode(true);
    }

    @Override
    public void configRoute(Routes me) {
        /**
         * 建立两个访问路由
         */
        me.add("/", IndexController.class,"/index");
        me.add("/Blog", BlogController.class);
    }

    @Override
    public void configPlugin(Plugins me) {
        // 配置C3p0数据库连接池插件
        C3p0Plugin C3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"),PropKit.get("user"),PropKit.get("password").trim());
        me.add(C3p0Plugin);

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(C3p0Plugin);
        me.add(arp);

        arp.addMapping("Blog", Blog.class);
    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }
}
