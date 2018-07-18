package com.template.sbssth.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PropertySource("classpath:global.properties")
public class DefaultController {

    @Value("${name}")
    private String name;

    @Value("${email}")
    private String email;

    @Value("${Sources}")
    private String Sources;

    @GetMapping("/")
    public String home1(Model model) {

        model.addAttribute("msg", "<h1>END</h1><br /><h2>END</h2>");
        model.addAttribute("msg", "<h1>END</h1><br /><h2>END</h2>");
        model.addAttribute("msg", "<h1>END</h1><br /><h2>END</h2>");


        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("name", name);
        model.addAttribute("Sources", Sources);


        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

}
