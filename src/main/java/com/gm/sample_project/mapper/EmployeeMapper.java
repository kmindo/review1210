package com.gm.sample_project.mapper;

import java.util.List;

import com.gm.sample_project.data.EmployeeHistoryVO;
import com.gm.sample_project.data.EmployeeVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {
    public void addEmployeeInfo(EmployeeVO data);
    public List<EmployeeVO> getEmployeeList(String type, String keyword, Integer offset);
    public Integer getEmployeeCnt(String type, String keyword);
    public void deleteEmployeeInfo(Integer seq);
    public Integer isExistEmployee(Integer seq);
    public EmployeeVO getEmployeeInfoBySeq(Integer seq);
    public void updateEmployeeInfo(EmployeeVO data);

    public void insertEmployeeHistory(EmployeeHistoryVO data);
    public Integer getRecentAddedEmployeeSeq();
}
