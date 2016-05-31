package com.asiainfo.controller;

import com.alibaba.fastjson.JSON;
import com.asiainfo.common.ShellUtils;
import com.asiainfo.model.Blog;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * com.asiainfo.controller
 * jfinal_idea
 * Created by nixinsheng on 2016/5/31 0031.
 */
public class BlogController extends Controller {
//    private static Logger log = Logger.getLogger(BlogController.class);

    private  static Logger log = Logger.getLogger(BlogController.class);
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

    /**
     *  网络 get测试
     *  http://localhost:8080/Blog/nxs_lv/倪新生-123
     */
    public void nxs_lv() {
        // 开始也是一个json串方式，其中"sql_SpreadIDs": "32|43|39" 待推送数据ID集合
        // String jsonStr = HttpKit.readIncommingRequestData(getRequest());
        // renderJson(jsonStr+"nixinsheng");

        System.out.println("****************nxs_lv Begin****************");


        String name=getPara(1).toString();
        System.out.print(name);
        try {
            System.out.println(URLEncoder.encode(name,"UTF-8"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("get方式传参：name=" + getPara(0).toString() + ";age="
                    + (new String(name.getBytes("iso8859-1"),"GBK")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        renderText("get方式传参：name=" + getPara(0).toString() + ";age="
                + getPara(1).toString());
    }

    /**
     * 文件上传
     */
    public void Upload() {
        //拼接最终反馈json用
        HashMap<String, Object> rep = new HashMap<String, Object>();
        HashMap<String, Object> repdetail = new HashMap<String, Object>();
        String ResultCode = "";//返回结果编码
        String ResultDesc = "";//返回结果描述
        //************要是UploadFile必须放在最前面 就要做临时文件夹 或者 文件拷贝工作（文件拷贝还要考虑删除临时的文件夹）
        System.out.println("******接口操作保存文件开始*******");
        log.debug("******接口操作保存文件开始*******");
        //"C:/Users/Administrator/Desktop/NXW/home/as_dev/pics/temp"  放服务器上的指定地址  本地测试地址
        //"/home/as_dev/pics/temp"  放服务器上的指定地址  服务器上测试库真实地址
        //"/home/tomcat/pics/temp"  放服务器上的指定地址  服务器上生产库真实地址

        //String server_temp ="C:/Users/Administrator/Desktop/NXW/home/as_dev/pics/temp";
        //UploadFile file = getFile("filename", "C:/Users/Administrator/Desktop/NXW/home/as_dev/pics/temp"); //测试
        //UploadFile file = getFile("filename", "/home/timcat/pics/temp");  //服务器生产库
        UploadFile file = getFile("filename", "/home/as_dev/pics/temp");  //服务器测试库

        String PATHNAME = getPara("pathname");
        String fileName = file.getFileName();
        //String extension = fileName.substring(fileName.lastIndexOf("."));

        System.out.println("目的保存路径(PATHNAME)："+PATHNAME);
        File source = file.getFile();
        System.out.println("临时保存地址:"+source);

        //这个新的NXS_target也是要进行拼接的
        //"C:/Users/Administrator/Desktop/NXW/home/as_dev/pics/"+PATHNAME; 服务端目的保存路径  测试用
        //"/home/as_dev/pics/"+PATHNAME; 服务端目的保存路径  服务器上测试库用
        //"/home/tomcat/pics/"+PATHNAME; 服务端目的保存路径  服务器上生产库用

        //String NXS_Target = "C:/Users/Administrator/Desktop/NXW/home/as_dev/pics/"+PATHNAME;
        String NXS_Target = "/home/as_dev/pics/Message/"+PATHNAME;
        try {
            FileInputStream fis = new FileInputStream(source);
            File targetDir = new File(NXS_Target);
            if (!targetDir.exists()) {
                targetDir.mkdirs();
            }
            File target = new File(targetDir, fileName);
            if (!target.exists()) {
                target.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(target);
            byte[] bts = new byte[5000];
            while (fis.read(bts, 0, 5000) != -1) {
                fos.write(bts, 0, 5000);
            }
            fos.close();
            fis.close();

            //最上层目录temp是要进行拼接的
            //Boolean flagBoolean =  deleteDir(new File(server_temp));
            //删除temp临时文件夹里的文件
            Boolean flagBoolean = source.delete();
            if (flagBoolean) {
                ResultCode="0";
                ResultDesc="文件保存成功";
            }else {
                ResultCode="-1";
                ResultDesc="文件保存失败";
            }
            System.out.println("删除临时存放文件夹及文件——————"+flagBoolean);
            log.debug("删除临时存放文件夹及文件——————"+flagBoolean);
            /**
             * 文件后缀
             */
            String extension = fileName.substring(fileName.lastIndexOf("."));

            //图片不处理
            if (extension.equals(".amr")) {//音频
                String cmd1 = "cd "+NXS_Target;
                String cmd2 = "amr2mp3 "+fileName;
                String[] cmdStrings = {cmd1,cmd2};
                log.debug(ShellUtils.execCommand(cmdStrings,false,true).successMsg);
                log.debug("***************XXX.amr 文件转amr2mp3完毕.***************");
                Thread.sleep(1000);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        repdetail.put("ResultCode", ResultCode);
        repdetail.put("ResultDesc", ResultDesc);
        rep.put("Rsp", repdetail);
        System.out.println("文件保存Msg："+ JSON.toJSONString(rep));
        log.debug("文件保存Msg："+JSON.toJSONString(rep));
    }

}
