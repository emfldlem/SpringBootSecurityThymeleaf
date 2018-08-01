package com.template.sbssth.Board.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class BoardDetail {

    @Column
    @Id
    private Long boardDtId;

    @Column
    private Long boardId;

    @Column
    private String boardSj;

    @Column
    private String boardCt;

    @Column
    private String regUsr;

    @Temporal(TemporalType.DATE)
    private Date regDt;


}
