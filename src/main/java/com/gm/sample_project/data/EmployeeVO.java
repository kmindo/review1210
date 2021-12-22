package com.gm.sample_project.data;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeVO {
    private Integer ei_seq;
    private String ei_number;
    private String ei_name;
    private String ei_birth;
    private String ei_phone_num;
    private String ei_pwd;
    private String ei_email;
    private Integer ei_status;
    private Date ei_reg_dt;
    private Date ei_mod_dt;

    public String makeHistoryStr(){
        return ei_number+"|"+ei_name+"|"+ei_birth+"|"+ei_phone_num+"|"+ei_email+"|"+ei_status;
    }
}
