package com.gm.sample_project.mapper;

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
    public Integer getReadyBookCnt();
    public Integer getUnavailableBookCnt();

    public Integer getTotalReviewCnt();
    public Integer getNowReviewCnt();
    public Integer getDeleteReviewCnt();;
}
