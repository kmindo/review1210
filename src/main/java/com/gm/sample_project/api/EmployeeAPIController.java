package com.gm.sample_project.api;

import java.util.Map;

import com.gm.sample_project.data.EmployeeVO;
import com.gm.sample_project.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeAPIController {
    @Autowired EmployeeService service;
    @PostMapping("/employee/add")
    public Map<String, Object> postEmployeeAdd(@RequestBody EmployeeVO data) throws Exception{
        return service.addEmployeeInfo(data);
    }
    @DeleteMapping("/employee/delete")
    public Map<String, Object> deleteEmployeeInfo(@RequestParam Integer seq){
        return service.deleteEmployeeInfo(seq);
    }
    @GetMapping("/employee/get")
    public EmployeeVO getEmployeeInfoBySeq(@RequestParam Integer seq){
        return service.getEmployeeInfoBySeq(seq);
    }
    @PatchMapping("/employee/modify")
    public Map<String, Object> patchEmployeeInfo(@RequestBody EmployeeVO data){
        return service.patchEmployeeInfo(data);
    }
}
