package com.gm.sample_project.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.gm.sample_project.data.ReviewVO;
import com.gm.sample_project.mapper.ReviewMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired ReviewMapper mapper;    
    public Map<String, Object> addReview(ReviewVO data) throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        mapper.addReview(data); 

        resultMap.put("status", true);
        resultMap.put("message", "리뷰가 추가되었습니다.");
        return resultMap;
    }
    public Map<String, Object> getReviewList(String type, String keyword, Integer offset){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(keyword == null){
            resultMap.put("keyword", keyword);
            keyword = "%%";
        }
        else{ 
            resultMap.put("keyword", keyword);
            keyword = "%"+keyword+"%";
        }

        resultMap.put("type", type);

        if(offset == null) offset = 0;

        List<ReviewVO> list = mapper.getReviewList(type, keyword, offset);

        Integer cnt = mapper.getReviewCnt(type, keyword);

        Integer page = cnt/10;
        if(cnt % 10 > 0) page++;

        resultMap.put("status", true);
        resultMap.put("pageCnt", page);
        resultMap.put("list", list);

        return resultMap;
    }
    public Map<String, Object> deleteReview(Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        mapper.deleteReview(seq);
        resultMap.put("status",true);
        resultMap.put("message", "리뷰가 삭제되었습니다.");
        return resultMap;
    }
    public ReviewVO getReviewInfoBySeq(Integer seq){
        return mapper.getReviewInfoBySeq(seq);
    }
    public Map<String, Object> patchReviewInfo(ReviewVO data){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        mapper.updateReviewInfo(data);
        resultMap.put("status", true);
        resultMap.put("message", "수정되었습니다.");
        
        return resultMap;
    }
}
