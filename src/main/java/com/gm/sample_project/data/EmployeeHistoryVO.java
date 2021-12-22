package com.gm.sample_project.data;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeHistoryVO {
    private Integer eih_seq;
    private Integer eih_ei_seq;
    private String eih_type;
    private String eih_content;
    private Date eih_reg_dt;
}
