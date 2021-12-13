package com.gm.sample_project.data;


import java.util.Date;

import lombok.Data;

@Data
public class BookVO {
    private Integer bi_seq;
    private String bi_sc_seq;
    private String bi_name;
    private String bi_publisher;
    private String bi_author;
    private Integer bi_stock;
    private Integer bi_price;
    private Integer bi_star;
    private String bi_image;
    private String bi_introduce;
    private String bi_pub_date;
    private Integer bi_status;
    private Date bi_reg_dt;
    private Date bi_mod_dt;
    
}
