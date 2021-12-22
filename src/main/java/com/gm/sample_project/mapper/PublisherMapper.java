package com.gm.sample_project.mapper;

import java.util.List;

import com.gm.sample_project.data.PublisherVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PublisherMapper {
    public List<PublisherVO> getPublisherInfo(Integer offset);
    public void addPublisherInfo(PublisherVO data);
    // public Integer getPublisherCount();
    public PublisherVO getPublisherInfoBySeq(Integer seq);
    public List<PublisherVO> getPublisherByKeyword(String keyword);
    public void deletePublisherInfo(Integer seq);
    public Integer isExistPublisher(Integer seq);
    public void updatePublisher(PublisherVO data);
}
