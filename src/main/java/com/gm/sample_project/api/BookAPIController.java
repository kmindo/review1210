package com.gm.sample_project.api;

import java.util.Map;

import com.gm.sample_project.data.BookVO;
import com.gm.sample_project.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookAPIController {
    @Autowired BookService service;
    @PostMapping("/book/add")
    public Map<String, Object> postBookAdd(@RequestBody BookVO data){
        return service.addBook(data);
    }
    @DeleteMapping("/book/delete")
    public Map<String, Object> deleteBook(@RequestParam Integer seq){
        return service.deleteBook(seq);
    }
    @GetMapping("/book/get")
    public Map<String, Object> getBookInfoBySeq(@RequestParam Integer seq){
        return service.getBookInfoBySeq(seq);
    }
    @PatchMapping("/book/update")
    public Map<String, Object> patchBookInfo(@RequestBody BookVO data){
        return service.updateBookInfo(data);
    }
}
