package com.gm.sample_project.mapper;

import java.util.List;

import com.gm.sample_project.data.BookHistoryVO;
import com.gm.sample_project.data.BookVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    public List<BookVO> getBookInfo(Integer offset, String keyword);
    public Integer getBookCount(String keyword);
    public void addBook(BookVO data);
    public void deleteBook(Integer seq);
    public BookVO getBookInfoBySeq(Integer seq);
    public void updateBook(BookVO data);
    public Integer selectLatestDataSeq();
    public void insertBookHistory(BookHistoryVO data);
}
