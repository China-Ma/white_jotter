package com.china.white_jotter.admin.service.impl;

import com.china.white_jotter.admin.entity.Book;
import com.china.white_jotter.admin.entity.BookExample;
import com.china.white_jotter.admin.entity.BookVo;
import com.china.white_jotter.admin.entity.Category;
import com.china.white_jotter.admin.mapper.BookMapper;
import com.china.white_jotter.admin.service.BookService;
import com.china.white_jotter.admin.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author majiaju
 * @date
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper bookMapper;
    @Autowired
    CategoryService categoryService;


    @Override
    public List<BookVo> list() {
        BookExample example = new BookExample();
        BookExample.Criteria criteria = example.createCriteria();
        List<BookVo> bookVos = new ArrayList<>();
        List<Book> books = bookMapper.selectByExample(example);
        for (Book book : books){
            BookVo bookVo = new BookVo();
            BeanUtils.copyProperties(book,bookVo);
            Category category = categoryService.get(book.getCid());
            bookVo.setCategory(category);
            bookVos.add(bookVo);
        }

        return bookVos;
    }

    @Override
    public void save(Book book) {
        if (book.getId()!=null){
            bookMapper.updateByPrimaryKeySelective(book);
            return;
        }
        bookMapper.insert(book);
    }

    @Override
    public void deleteById(int id) {
        bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<BookVo> listByCategory(int cid) {
        BookExample example = new BookExample();
        BookExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        List<Book> books = bookMapper.selectByExample(example);
        List<BookVo> bookVos = new ArrayList<>();
        for (Book book : books){
            BookVo bookVo = new BookVo();
            BeanUtils.copyProperties(book,bookVo);
            Category category = categoryService.get(book.getCid());
            bookVo.setCategory(category);
            bookVos.add(bookVo);
        }

        return bookVos;
    }
}
