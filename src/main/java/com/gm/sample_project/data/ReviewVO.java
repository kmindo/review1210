package com.gm.sample_project.data;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {
    private Integer br_seq;
    private Integer br_bi_seq;
    private Integer br_mi_seq;
    private String br_title;
    private String br_text;
    private Integer br_star;
    private Integer br_image;
    private Integer br_status;
    private Date br_reg_dt;
    private Date br_mod_dt;
    private String book_name;
}
