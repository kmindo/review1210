package com.gm.sample_project.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.gm.sample_project.data.EmployeeHistoryVO;
import com.gm.sample_project.data.EmployeeVO;
import com.gm.sample_project.mapper.EmployeeMapper;
import com.gm.sample_project.utils.AESAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired EmployeeMapper mapper;
    public Map<String, Object> addEmployeeInfo(EmployeeVO data) throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if(data.getEi_number().equals("") || data.getEi_number() == null){
            resultMap.put("status", false);
            resultMap.put("reason", "number");
            resultMap.put("message", "직원번호를 입력해주세요");
            return resultMap;
        }
        if(data.getEi_name().equals("") || data.getEi_name() == null){
            resultMap.put("status", false);
            resultMap.put("reason", "name");
            resultMap.put("message", "이름을 입력해주세요");
            return resultMap;
        }
        if(data.getEi_birth().equals("") || data.getEi_birth() == null){
            resultMap.put("status", false);
            resultMap.put("reason", "birth");
            resultMap.put("message", "생년월일을 입력해주세요");
            return resultMap;
        }
        if(data.getEi_phone_num().equals("") || data.getEi_phone_num() == null){
            resultMap.put("status", false);
            resultMap.put("reason", "phone");
            resultMap.put("message", "전화번호를 입력해주세요");
            return resultMap;
        }
        if(data.getEi_email().equals("") || data.getEi_email() == null){
            resultMap.put("status", false);
            resultMap.put("reason", "email");
            resultMap.put("message", "이메일을 입력해주세요 ");
            return resultMap;
        }

        String pwd = data.getEi_pwd();
        String encrypted = AESAlgorithm.Encrypt(pwd);
        data.setEi_pwd(encrypted);
        
        mapper.addEmployeeInfo(data); 

        EmployeeHistoryVO history = new EmployeeHistoryVO();
        history.setEih_type("new");
        history.setEih_content(data.makeHistoryStr());
        Integer recent_seq = mapper.getRecentAddedEmployeeSeq();
        history.setEih_ei_seq(recent_seq);

        mapper.insertEmployeeHistory(history);

        resultMap.put("status", true);
        resultMap.put("message", "직원 정보가 추가되었습니다.");
        return resultMap;
    }
    public Map<String, Object> getEmployeeList(String type, String keyword, Integer offset){
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

        List<EmployeeVO> list = mapper.getEmployeeList(type, keyword, offset);

        Integer cnt = mapper.getEmployeeCnt(type, keyword);

        Integer page = cnt/10;
        if(cnt % 10 > 0) page++;

        resultMap.put("status", true);
        resultMap.put("pageCnt", page);
        resultMap.put("list", list);

        return resultMap;
    }
    public Map<String, Object> deleteEmployeeInfo(Integer seq){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        Integer cnt = mapper.isExistEmployee(seq);
        if(cnt == 0){
            resultMap.put("status", false);
            resultMap.put("message", "삭제에 실패했습니다. (존재하지 않는 직원 정보)");
        }
        else {
            mapper.deleteEmployeeInfo(seq);
            resultMap.put("status", true);
            resultMap.put("message", "삭제했습니다.");

            EmployeeHistoryVO history = new EmployeeHistoryVO();
            history.setEih_type("delete");
            history.setEih_ei_seq(seq);
            mapper.insertEmployeeHistory(history);
        }
        return resultMap;
    }
    public EmployeeVO getEmployeeInfoBySeq(Integer seq) {
        return mapper.getEmployeeInfoBySeq(seq);
    }
    public Map<String, Object> patchEmployeeInfo(EmployeeVO data){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        mapper.updateEmployeeInfo(data);
        resultMap.put("status", true);
        resultMap.put("message", "수정되었습니다.");

        EmployeeHistoryVO history = new EmployeeHistoryVO();
        history.setEih_type("modify");
        history.setEih_content(data.makeHistoryStr());
        history.setEih_ei_seq(data.getEi_seq());

        mapper.insertEmployeeHistory(history);

        return resultMap;
    }
}

