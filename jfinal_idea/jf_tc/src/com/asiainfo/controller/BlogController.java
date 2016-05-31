package com.asiainfo.controller;

import com.asiainfo.model.Blog;
import com.jfinal.core.Controller;

/**
 * com.asiainfo.controller
 * jfinal_idea
 * Created by nixinsheng on 2016/5/31 0031.
 */
public class BlogController extends Controller {

    public void index(){
        render("index.jsp");
    }
    public void form(){
        render("form.jsp");
    }
    public void blogadd(){
        Blog blog=getModel(Blog.class,"blog");
        blog.save();
        index();

    }
}
