package com.gm.sample_project.data;

import java.util.Date;

import lombok.Data;

@Data
public class BookHistoryVO {
    private Integer bkh_seq;
    private String bkh_type;
    private String bkh_content;
    private Date bkh_reg_dt;
    private Integer bkh_bi_seq;
}
