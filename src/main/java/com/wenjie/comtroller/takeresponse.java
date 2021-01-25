package com.wenjie.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class takeresponse {



    @RequestMapping("/testresponse")
    public void testvoid(HttpServletRequest req, HttpServletResponse rep){

        try {
            req.getRequestDispatcher("/pages/success.jsp").forward(req,rep);
        } catch (ServletException e) {
            e.printStackTrace();
            System.out.println("没有知道转发的资源");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("数据发送失败了");
        }

        System.out.println("执行了testresponse的代码");
        /*他没有走视图解析器*/
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView view =new ModelAndView();
        view.addObject("aaa","a");
        view.setViewName("success");    /*这个走视图解析器了*/
        System.out.println("执行了testModelandview");
        return view;
    }

    @RequestMapping("/testString01")
    public String testString01(){
        System.out.println("执行了testString01的程序");
        return "forward:/pages/success.jsp";   /*没有走视图解析器*/        /*转发类型*/
    }


    @RequestMapping("/testString02")
    public String testString02(){
        System.out.println("执行了testString02代码");
        return "redirect:/pages/success.jsp";     /*没有走视图解析器*/        /*重定向*/
                /*已经自动的添加了request.getcontextpath 不需要在此添加*/
    }
}
