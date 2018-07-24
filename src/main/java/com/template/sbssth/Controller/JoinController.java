package com.template.sbssth.Controller;

import com.template.sbssth.Dao.CustomerRepository;
import com.template.sbssth.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping(value = "/join")
//@PropertySource("classpath:global.properties")
public class JoinController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/step1")
    public String join_step1(Model model) {
        //model.addAttribute("customers", repository.findAll());
        return "/join/join";
    }

    @GetMapping("/step2")
    public String join_step_2(Model model) {
        return "/join/join_step_2";
    }

    @PostMapping("/join_insert")
    public String join_insert(Customer customer) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        //List<String> MauthList = new ArrayList<>();
        //MauthList.add("A");
        customer.setMAuth("A");
        customer.setCreated_date(new Date());

        customerRepository.save(customer);

        return "redirect:/home";

    }
}
