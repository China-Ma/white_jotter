package com.china.white_jotter.admin.controller;

import com.china.white_jotter.admin.entity.Book;
import com.china.white_jotter.admin.entity.BookVo;
import com.china.white_jotter.admin.service.BookService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author majiaju
 * @date
 */
@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @RequestMapping("/api/books")
    public List<BookVo> list() throws Exception{
        return bookService.list();
    }

    @RequestMapping(value = "/api/save",method = RequestMethod.POST)
    public Book save(@RequestBody Book book) throws Exception{
        bookService.save(book);
        return book;
    }

    @RequestMapping(value = "/api/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Book book) throws Exception{
        bookService.deleteById(book.getId());
    }

    @RequestMapping("/api/search")
    public List<BookVo> listByCid(int cid) throws Exception{
        if (cid == 0){
            return bookService.list();
        }
        return bookService.listByCategory(cid);
    }


}
