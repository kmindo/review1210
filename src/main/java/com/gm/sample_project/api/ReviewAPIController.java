package com.gm.sample_project.api;

import java.util.Map;

import com.gm.sample_project.data.ReviewVO;
import com.gm.sample_project.service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewAPIController {
    @Autowired ReviewService service;
    @PostMapping("/review/add")
    public Map<String, Object> postReviewAdd(@RequestBody ReviewVO data) throws Exception{
        return service.addReview(data);
    }
    @DeleteMapping("/review/delete")
    public Map<String, Object> deleteReview(@RequestParam Integer seq){
        return service.deleteReview(seq);
    }
    @GetMapping("/review/get")
    public ReviewVO getReviewInfoBySeq(@RequestParam Integer seq){
        return service.getReviewInfoBySeq(seq);
    }
    @PatchMapping("/review/modify")
    public Map<String, Object> patchReviewInfo(@RequestBody ReviewVO data){
        return service.patchReviewInfo(data);
    }
}
