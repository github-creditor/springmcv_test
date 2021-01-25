package com.wenjie.comtroller;

import com.wenjie.service.demo;
import com.wenjie.service.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SessionAttributes("aa")
@Controller
public class Takerequest {

    /*  requestmapping中可以不用写里面的参数
        默认的话，他会自动的将value的值填写的方法的名称
        但是不写的话，一个类中只能有一个不进行书写
        否则的话就会报错
    *
    * */

    @RequestMapping("/hello")
    public String sayhell(){
        System.out.println("第一个程序");
        return "success";
    }


    /*设置将请求参数封装到user类中*/
    /*还可以将实体类中添加一些list或map的变量*/
    @RequestMapping("/user")
    public String takeuser(user u){

        System.out.println(u);
        return "success";
        }

        /*通过springmvc获取servlet原生api*/
    @RequestMapping("/getcontext")
    public String getservelt(HttpServletRequest req, HttpServletResponse resp){
        System.out.println(req);

        HttpSession session = req.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(resp);

        return "success";
    }

    /*使用requestparam
    *   有两个属性
    *   value：解决传递的名称不匹配，导致无法封装的情况
    *   required： 当取值为true时，代表的含义是如果没有一个名称为name的请求参数的话，就会报错
    * */
    @RequestMapping("/testRequestParam")
    public String testRequestParam( @RequestParam(value = "take",required=true) String name){
        System.out.println(name);
        return "success";
    }

    /*使用requestbody
        作用：用于获取请求体的内容，直接使用得到的是key=value&key=value结构的数据（get方式不适用）
        属性：
            value
            required：当取值为true时，当取值为get方式会报错，如果为false时，get请求得到的是null

    * */
    @RequestMapping("/takeRequestBody")
    public String takeRequestBody(@RequestBody String body){

        System.out.println(body);

        return "success";
    }

    /*pathvariable
    *   请求url中/delete/{id}，这个{id}就是占位符。
    *   （url支持占位符是spring3.0之后加入的，是springmvc支持restful风格url的一个重要标志）
    *
    *   属性：
    *   value
    *   required：是否必须提供占位符
    * */
    @RequestMapping("/takePathVariable/{id}")
    public String takePathVariable(@PathVariable("id") String id){
        System.out.println("测试成功");
        System.out.println(id);
        return "success";
    }

    /*HiddenHttpMethodFilter过滤器
    *   太麻烦了。。没看
    *
    * */

    /*  requestheader
        作用：用于获取请求消息头
        属性：
            value：提供消息头名称
            required：是否必须有此消息头

         开发中一般不用
    *
    * */
    @RequestMapping("/takeRequestHeader")
    public String takeRequestHeader(@RequestHeader("accept") String header){
        System.out.println(header);
        return "success";
    }

    /*cookieValue
    *   作用：把浏览器中的cookie传到参数中
         属性：
    * value：
    * required：是否必须有cookie
    *
    * */
    @RequestMapping("/takecookievalue")
    public String takecookievalue(@CookieValue("JSESSIONID") String cookie){
        System.out.println(cookie);
        return "success";
    }

    /*modelattribute
    *   作用：该注解是springmvc4.3版本之后加入的，他可以用于修饰方法和参数

        出现在方法上：表示当前方法会在控制器执行之前执行。它可以修饰没有返回值的方法，也可以修饰有具体返回值的方法
        出现在参数上，获取指定的数据给参数赋值
        属性：

        value：用于获取数据的key。key可以是POJO的属性名称，也可以是map结构的key
        应用场景：

        当表单提交数据不是完整的实体类数据时，保证没有提交数据的字段使用数据库对象原来的数据
        例如：我们在编辑一个用户时，用户有一个创建信息的字段，该字段的值是不允许被修改的。在提交表单数据是肯定没有此字段的内容，一旦更新会把该字段内容置为null，此时就可以使用此注解解决问题
    *
    *
    *   尝试：他的意思是
    *   我在客户端的时候就没有写一些类的参数
    *   然后我就可以通过这一个参数设置一个默认值
    *
    *   但是如果客户端配置过的
    *   他默认是空，而不是没有
    *   所以也会被替换
    *
    *
    *
    *
    * */


    @RequestMapping("/takedemo")
    public String takedemo(@ModelAttribute("aaa") demo aa){

        System.out.println(aa);
        return "success";
    }

    @ModelAttribute("aaa")
    public demo takea(String name){
        demo de = new demo();
        de.setName("name");
        de.setValue("默认");
       return de;
    }

    /*sessionattributes
        用于多次执行控制器方法间的参数共享
        相当于是session


    *   有三个参数
    *   model           方法 addAttribute  添加         他底层使用的是request
    *   modelMap        方法 get          获取
    *   sessionStatus   方法 sessionstatus 删除

    * */
    @RequestMapping("/a1")
    public String sessionAttribute1(Model model){

        model.addAttribute("aa","a");
        return "success";
    }
    @RequestMapping("/a2")
    public String sessionAttribute2(ModelMap modelmap){
        Object o = modelmap.get("aa");
        System.out.println(o);
        return "success";
    }
    @RequestMapping("/a3")
    public String sessionAttribute3(SessionStatus sessionstatus){
        sessionstatus.setComplete();

        return "success";
    }











}
