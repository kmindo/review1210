package com.gm.sample_project.api;

import java.util.Map;

import com.gm.sample_project.data.MemberVO;
import com.gm.sample_project.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberAPIController {
    @Autowired MemberService service;
    @PostMapping("/member/add")
    public Map<String, Object> postTeacherAdd(@RequestBody MemberVO data) throws Exception{
        return service.addMemberInfo(data);
    }
}
