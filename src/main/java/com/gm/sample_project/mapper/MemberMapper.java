package com.gm.sample_project.mapper;

import com.gm.sample_project.data.MemberVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public void addMemberInfo(MemberVO data);
}
