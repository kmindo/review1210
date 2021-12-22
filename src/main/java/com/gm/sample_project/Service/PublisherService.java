package com.gm.sample_project.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.gm.sample_project.data.PublisherVO;
import com.gm.sample_project.mapper.PublisherMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    @Autowired PublisherMapper mapper;
    public Map<String, Object> getPublisherList(Integer offset){
        if(offset == null) offset= 0;
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<PublisherVO> list = mapper.getPublisherInfo(offset);
        
        resultMap.put("status", true);
        resultMap.put("list", list);
        return resultMap;
    }
    public Map<String, Object> getPublisherByKeyword(String keyword){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        if(keyword == null) keyword = "%%";
        keyword = "%"+keyword+"%";

        List<PublisherVO> list = mapper.getPublisherByKeyword(keyword);

        resultMap.put("status", true);
        resultMap.put("list", list);
        return resultMap;
    }
    public Map<String, Object> addPublisherInfo(PublisherVO data){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        mapper.addPublisherInfo(data); 

        resultMap.put("status", true);
        resultMap.put("message", "출판사 정보가 추가되었습니다.");
        return resultMap;
    }
    public Map<String, Object> deletePublisherInfo(Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        Integer cnt = mapper.isExistPublisher(seq);
        if(cnt == 0){
            resultMap.put("status", false);
            resultMap.put("message", "삭제에 실패했습니다. (존재하지 않는 출판사 정보)");
        }
        else {
            mapper.deletePublisherInfo(seq);
            resultMap.put("status", true);
            resultMap.put("message", "삭제했습니다.");
        }
        return resultMap;
    }
    public Map<String, Object> getPublisherInfoBySeq(Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        resultMap.put("status",true);
        resultMap.put("data", mapper.getPublisherInfoBySeq(seq));
        return resultMap;
    }
    public Map<String, Object> updatePublisherInfo(PublisherVO data){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        mapper.updatePublisher(data);
        resultMap.put("status",true);
        resultMap.put("message", "수정되었습니다.");
        return resultMap;
    }
}
