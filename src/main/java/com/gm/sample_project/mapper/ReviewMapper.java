package com.gm.sample_project.mapper;

import java.util.List;

import com.gm.sample_project.data.ReviewVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    public void addReview(ReviewVO data);
    public List<ReviewVO> getReviewList(String type, String keyword, Integer offset);
    public Integer getReviewCnt(String type, String keyword);
    public void deleteReview(Integer seq);
    public ReviewVO getReviewInfoBySeq(Integer seq);
    public void updateReviewInfo(ReviewVO data);
}
