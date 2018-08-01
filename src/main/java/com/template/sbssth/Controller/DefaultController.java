package com.template.sbssth.Controller;

import com.template.sbssth.Dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@PropertySource("classpath:global.properties")
public class DefaultController {

    @Value("${name}")
    private String name;

    @Value("${email}")
    private String email;

    @Value("${Sources}")
    private String Sources;

    @Autowired
    CustomerRepository repository;

    @GetMapping("/")
    public String home1(Model model) {

        model.addAttribute("customers", repository.findAll());
        return "/home";
    }


    @GetMapping("/login")
    public String login(Model model, HttpServletRequest req) {

        String referer = req.getHeader("Referer");
        req.getSession().setAttribute("prevPage",referer);

        model.addAttribute("name", name);
        model.addAttribute("Sources", Sources);

        return "/login/login";
    }


    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }





















    @GetMapping("/findall")
    public String findAll(Model model){

        String result = "";

        model.addAttribute("customers", repository.findAll());

        /*for(Customer cust : repository.findAll()){
            result += cust + "</br>";
            System.out.println(cust);
        }*/
        return "/findall";
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





}
