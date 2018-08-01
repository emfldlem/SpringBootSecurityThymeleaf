package com.template.sbssth.Board.Controller;

import com.template.sbssth.Board.Dao.BoardDetail2Repository;
import com.template.sbssth.Board.Dao.BoardDetailRepository;
import com.template.sbssth.Board.Model.BoardDetail;
import com.template.sbssth.Board.Service.BoardDetailServiceImpl;
import com.template.sbssth.Model.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@RestController
@RequestMapping("/restboard")
public class RestBoardController {
    private static Logger logger = LoggerFactory.getLogger(RestBoardController.class);

    @Autowired
    BoardDetailRepository boardDetailRepository;

    @Autowired
    BoardDetail2Repository boardDetail2Repository;

    @Autowired
    BoardDetailServiceImpl boardDetail1Service;

    @GetMapping("/freeboard")
    public ResponseEntity<Pagination> getFreeBoard(@RequestParam(value = "page") int page, Pageable pageable) {
        logger.error("start");

        Pagination pageResult = new Pagination();
        pageResult.setPage(page);
        pageResult.setTotalCount(boardDetailRepository.countByAll());



        List<BoardDetail> freeboard = new ArrayList<>();
        //freeboard = boardDetailRepository.findAllBy(pageable);

        pageResult.setData(freeboard);

        return new ResponseEntity<Pagination>(pageResult, HttpStatus.OK);
    }

    @GetMapping("/freeboard2")
    public Page<BoardDetail> listAll(Model model, Pageable pageable, HttpServletRequest request) {
        String aa = request.getRequestURI();
        Enumeration params = request.getParameterNames();
        System.out.println("----------------------------");
        while (params.hasMoreElements()){
            String name = (String)params.nextElement();
            System.out.println(name + " : " +request.getParameter(name));
        }
        System.out.println("----------------------------");



        return boardDetail1Service.getAllBoardDetail(pageable);

    }

    @PostMapping("/freeboard2")
    public Page<BoardDetail> listAll2(Model model, Pageable pageable, HttpServletRequest request) {
        String aa = request.getRequestURI();
        Enumeration params = request.getParameterNames();
        System.out.println("----------------------------");
        while (params.hasMoreElements()){
            String name = (String)params.nextElement();
            System.out.println(name + " : " +request.getParameter(name));
        }
        System.out.println("----------------------------");



        return boardDetail1Service.getAllBoardDetail(pageable);

    }

}
