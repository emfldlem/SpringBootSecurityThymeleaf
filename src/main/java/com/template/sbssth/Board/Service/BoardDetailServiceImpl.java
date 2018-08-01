package com.template.sbssth.Board.Service;

import com.template.sbssth.Board.Dao.BoardDetail2Repository;
import com.template.sbssth.Board.Model.BoardDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardDetailServiceImpl implements BoardDetailService {

    @Autowired
    BoardDetail2Repository boardDetailRepository;

    @Override
    public Page<BoardDetail> getAllBoardDetail(Pageable page) {

        return boardDetailRepository.findAll(page);
    }
}
