package com.gm.sample_project.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.gm.sample_project.data.MemberVO;
import com.gm.sample_project.mapper.MemberMapper;
import com.gm.sample_project.utils.AESAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired MemberMapper mapper;
    public Map<String, Object> addMemberInfo(MemberVO data) throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        
        if(data.getMi_id().equals("") || data.getMi_id() == null){
            resultMap.put("status", false);
            resultMap.put("reason", "id");
            resultMap.put("message", "ID를 입력해주세요");
            return resultMap;
        }
        if(data.getMi_name().equals("") || data.getMi_name() == null){
            resultMap.put("status", false);
            resultMap.put("reason", "name");
            resultMap.put("message", "이름을 입력해주세요");
            return resultMap;
        }
        if(data.getMi_phone_num().equals("") || data.getMi_phone_num() == null){
            resultMap.put("status", false);
            resultMap.put("reason", "phone");
            resultMap.put("message", "전화번호를 입력해주세요");
            return resultMap;
        }
        if(data.getMi_birth().equals("") || data.getMi_birth() == null){
            resultMap.put("status", false);
            resultMap.put("reason", "birth");
            resultMap.put("message", "생년월일을 입력해주세요");
            return resultMap;
        }
        if(data.getMi_email().equals("") || data.getMi_email() == null){
            resultMap.put("status", false);
            resultMap.put("reason", "email");
            resultMap.put("message", "이메일을 입력해주세요 ");
            return resultMap;
        }

        String pwd = data.getMi_pwd();
        String encrypted = AESAlgorithm.Encrypt(pwd);
        data.setMi_pwd(encrypted);

        mapper.addMemberInfo(data); 

        resultMap.put("status", true);
        resultMap.put("message", "회원 정보가 추가되었습니다.");
        return resultMap;
    }
}
