package com.template.sbssth.Board.Dao;

import com.template.sbssth.Board.Model.BoardDetail;
import com.template.sbssth.Model.Pagination;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface BoardDetailRepository extends CrudRepository<BoardDetail, Long> {
    @Query(value="SELECT T1.BOARD_DT_ID, T1.BOARD_ID, T1.BOARD_SJ, T1.REG_USR,T1.REG_DT,  T1.BOARD_CT from board_detail T1 where DELETE_YN = 'N' AND BOARD_ID = 1 \n-- #pageable\n",
            countQuery = "SELECT COUNT(*) FROM BOARD_MST WHERE DELETE_YN ='N' AND BOARD_ID =1",
            nativeQuery = true)
    List<BoardDetail> findAllBy(Pageable pageable);

    @Query(nativeQuery = true,
            value="SELECT COUNT(T1.BOARD_DT_ID) from board_detail T1 where DELETE_YN = 'N' AND BOARD_ID = 1")
    int countByAll();


    @Query(nativeQuery = true,
            value="SELECT T1.BOARD_DT_ID, T1.BOARD_ID, T1.BOARD_SJ, T1.REG_USR,T1.REG_DT,  T1.BOARD_CT from board_detail T1 where DELETE_YN = 'N' AND BOARD_ID = 1")
    List<BoardDetail> findAllBy(Pagination pagination);



}
