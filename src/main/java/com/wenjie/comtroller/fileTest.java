package com.wenjie.comtroller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebService;
import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller


/*测试文件上传
*   1.文件表单的enctype取值是multipart/form-data
*   2.method属性取值必须是post
*   3.提供一个文件选择域<input type="file">

*
*
* */

public class fileTest {

    @RequestMapping("filetest02")
    public String filetest02(){
        System.out.println("执行了filetest02的方法");
        return "fileTest";
    }



    /*传统方式
    *   如果使用了springmvc的文件解析的方式的话
    *   传统的方式就没有办法再使用了
    * */

    @RequestMapping("/filetest01")
    public String fileTest01(HttpServletRequest req) throws Exception {

        System.out.println("文件上传。。。");

/*
文件上传的位置*/


        String path = req.getSession().getServletContext().getRealPath("/uploads/");
        File file=new File(path);
        if (!file.exists()){
            file.mkdir();
        }
/*request对象，获取上传文件项*/

        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
/*解析request*/

        List<FileItem> fileItems = upload.parseRequest(req);
        for (FileItem item:fileItems){
/*进行判断，当前item对象是否是上传文件项*/

            if (item.isFormField()){
/*说明是一个普通的文件项*/

            }else {
                /*说明是上传文件项*/

          /*      获取到上传文件的名字*/

                String name = item.getName();
                System.out.println(name);
                if ("".equals(name)){
                    System.out.println("请传入数据");
                    break;
                }
/*把文件的名称设置为唯一值，uuid*/

                String replace = UUID.randomUUID().toString().replace("-", "");
                name=replace+name;
                System.out.println(name);

                item.write(new File(path, name));
/*删除临时文件*/

                item.delete();
            }
        }


        return "success";
    }


    /*springmvc上传
    *
    *   配置文件解析器后
    *   传统的方式就无法使用了
    *
    *
    *
    * */
    @RequestMapping("/filetest03")
    public ModelAndView filetest03(HttpServletRequest req, MultipartFile upload) throws IOException {

        String path = req.getSession().getServletContext().getRealPath("/uploads/");
        File file=new File(path);
        if (!file.exists()){
            file.mkdir();
        }

        /*  说明文件上传项
            获取上传文件的名称
        * */
        String name = upload.getOriginalFilename();

            /*
            * 把文件的名称设置唯一值
            * */
        String uuid = UUID.randomUUID().toString().replace("-", "");
        name= uuid + "_" + name;
        /*
        * 完成文件的上传
        * */
        upload.transferTo(new File(path,name));
        /*转发位置*/
        System.out.println("到转发的位置了");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /*
    *   进行跨服务器文件的上传
    *   细节：
    *   接收的服务器要开启可接收设置
    *
    *
    * */
    @RequestMapping("/filetest04")
    public ModelAndView filetest04(MultipartFile upload) throws IOException {
        /*
        *   定义上传文件服务器的路径
        * */

        String path="http://localhost:9090/blog/uploads/";
        /*说明上传文件项
        * 获取上传文件的名称
        * */
        String name = upload.getOriginalFilename();
        String replace = UUID.randomUUID().toString().replace("-", "");
        name=replace+name;

        /*
        *   创建客户端的
        * */
        Client client = Client.create();
        /*和图片服务器进行连接*/
        WebResource resource = client.resource(path+name);

        /*上传文件*/
        resource.put(upload.getBytes());

        System.out.println("将文件转发到其他服务器成功");
        /*转发*/
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("resourcestest")
    public ModelAndView resourcestest(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("testresources");
        return modelAndView;
    }






}
