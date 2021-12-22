package com.gm.sample_project.mapper;



import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DashboardMapper {
    public Integer getTotalMemberCnt();
    public Integer getActiveMemberCnt();
    public Integer getDeactiveMemberCnt();

    public Integer getTotalOrderCnt();
    public Integer getCompleteOrderCnt();
    public Integer getProgressOrderCnt();
    public Integer getCancelOrderCnt();
    
    public Integer getTotalBookCnt();
    public Integer getSellingBookCnt();
    public Integer getNoBookCnt();
    public Integer getUnavailableBookCnt();

    public Integer getTotalReviewCnt();
    public Integer getNowReviewCnt();
    public Integer getDeleteReviewCnt();

    public Integer getTotalEmployeeCnt();
    public Integer getNowEmployeeCnt();
    public Integer getVacationEmployeeCnt();
    public Integer getRestEmployeeCnt();

    public Date getBookUpdateDate();
    public Date getEmployeeUpdateDate();
}
