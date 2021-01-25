package com.wenjie.comtroller;

import com.wenjie.service.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class take {

    @ModelAttribute
    public void ta(String name, Map<String,demo> map){
        System.out.println("执行过");
        demo d=new demo();
        d.setName(name);
        d.setValue("..");
        map.put("aa",d);
    }

    @RequestMapping("/t")
    public String t(@ModelAttribute("aa") demo d){
        System.out.println(d);
        return "success";
    }
}
