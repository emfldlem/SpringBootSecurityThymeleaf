package com.template.sbssth.Board.Controller;

import com.template.sbssth.Board.Dao.BoardDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/board")
@PropertySource("classpath:global.properties")
public class BoardController {

    @Value("${name}")
    private String name;

    @Value("${email}")
    private String email;

    @Value("${Sources}")
    private String Sources;

    @Autowired
    BoardDetailRepository boardDetailRepository;



    @GetMapping("")
    public String board(Model model) {
        return "/board/board";
    }

    @GetMapping("/free")
    public String free_board(Model model) {

       // model.addAttribute("freeList", boardDetailRepository.findAllBy());

        return "/board/free_board";
    }

}
