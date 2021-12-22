package com.gm.sample_project.api;

import java.util.Map;

import com.gm.sample_project.data.PublisherVO;
import com.gm.sample_project.service.PublisherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherAPIController {
    @Autowired PublisherService service;
    @PostMapping("/publisher/add")
    public Map<String, Object> postPublisherAdd(@RequestBody PublisherVO data) throws Exception{
        return service.addPublisherInfo(data);
    }
    @GetMapping("/publisher/get")
    public Map<String, Object> getPublisherInfoBySeq(@RequestParam Integer seq){
        return service.getPublisherInfoBySeq(seq);
    }
    @GetMapping("/publisher/keyword")
    public Map<String, Object> getPublisherByKeyword(@RequestParam @Nullable String keyword){  
        return service.getPublisherByKeyword(keyword);
    }
    @DeleteMapping("/publisher/delete")
    public Map<String, Object> deletePublisherInfo(@RequestParam Integer seq){
        return service.deletePublisherInfo(seq);
    }
    @PatchMapping("/publisher/update")
    public Map<String, Object> patchPublisherInfo(@RequestBody PublisherVO data){
        return service.updatePublisherInfo(data);
    }
}
