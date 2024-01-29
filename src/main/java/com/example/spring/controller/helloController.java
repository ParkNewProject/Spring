package com.example.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
    // :8080/hello
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","data!");
        return "hello";
    }
    // :8080/hello-mvc?name=spring
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value="name", required = true) String name, Model model){
        model.addAttribute("name", name);
        return "hello-mvc";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value = "name", required = true) String name){
        return "hello "+name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(value = "name", required = true) String name){
        Hello hello = new Hello();
        hello.setName(name);
        // jsonConverter
        return hello;
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

    }

}
