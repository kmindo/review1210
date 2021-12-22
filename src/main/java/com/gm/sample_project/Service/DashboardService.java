package com.gm.sample_project.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.gm.sample_project.mapper.DashboardMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    @Autowired DashboardMapper mapper;

    public Map<String, Object> getCounts(){

        List<Integer> memCntList = new ArrayList<Integer>();
            memCntList.add(mapper.getTotalMemberCnt());
            memCntList.add(mapper.getActiveMemberCnt());
            memCntList.add(mapper.getDeactiveMemberCnt());

        List<Integer> orderCntList = new ArrayList<Integer>();
            orderCntList.add(mapper.getTotalOrderCnt());
            orderCntList.add(mapper.getCompleteOrderCnt());
            orderCntList.add(mapper.getProgressOrderCnt());
            orderCntList.add(mapper.getCancelOrderCnt());

        List<Integer> bookCntList = new ArrayList<Integer>();
            bookCntList.add(mapper.getTotalBookCnt());
            bookCntList.add(mapper.getSellingBookCnt());
            bookCntList.add(mapper.getNoBookCnt());
            bookCntList.add(mapper.getUnavailableBookCnt());

        List<Integer> reviewCntList = new ArrayList<Integer>();
            reviewCntList.add(mapper.getTotalReviewCnt());
            reviewCntList.add(mapper.getNowReviewCnt());
            reviewCntList.add(mapper.getDeleteReviewCnt());

        List<Integer> employeeCntList = new ArrayList<Integer>();
            employeeCntList.add(mapper.getTotalEmployeeCnt());
            employeeCntList.add(mapper.getNowEmployeeCnt());
            employeeCntList.add(mapper.getVacationEmployeeCnt());
            employeeCntList.add(mapper.getRestEmployeeCnt());
        
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("member", memCntList);
        map.put("order", orderCntList);
        map.put("book", bookCntList);
        map.put("review", reviewCntList);
        map.put("employee", employeeCntList);
        return map;
    }
    public Map<String, Object> getUpdateDate(){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        resultMap.put("book", mapper.getBookUpdateDate());
        resultMap.put("employee", mapper.getEmployeeUpdateDate());

        return resultMap;
    }
}
