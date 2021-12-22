package com.gm.sample_project.data;

import java.util.Date;

import lombok.Data;

@Data
public class PublisherVO {
    private Integer pi_seq;
    private String pi_name;
    private Integer pi_status;
    private Date pi_reg_dt;
    private Date pi_mod_dt;
}
