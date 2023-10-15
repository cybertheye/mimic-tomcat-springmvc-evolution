package xyz.cybertheye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * @description:
 */
@RestController // @Response + @Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    ApplicationContext context;

    @RequestMapping("/a")
    public String sayHello(){

        if(context instanceof AnnotationConfigWebApplicationContext){
            return "anno";
        }

        return "hello world";
    }
}
