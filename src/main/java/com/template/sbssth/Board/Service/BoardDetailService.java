package com.template.sbssth.Board.Service;

import com.template.sbssth.Board.Model.BoardDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardDetailService {
    Page<BoardDetail> getAllBoardDetail(Pageable page);

}
