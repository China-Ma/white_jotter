package com.china.white_jotter.admin.service;

import com.china.white_jotter.admin.entity.Book;
import com.china.white_jotter.admin.entity.BookVo;

import java.util.List;

/**
 * @author majiaju
 * @date
 */
public interface BookService {

    List<BookVo> list();

    void save(Book book);

    void deleteById(int id);

    List<BookVo> listByCategory(int cid);

}
