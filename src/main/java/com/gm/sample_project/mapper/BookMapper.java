package com.gm.sample_project.mapper;

import java.util.List;

import com.gm.sample_project.data.BookVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    public List<BookVO> getBookInfo(Integer seq);
    public Integer getBookCount();
    public void addBook(BookVO data);
    public void deleteBook(Integer seq);
}
