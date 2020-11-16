package com.china.white_jotter.admin.controller;

import com.china.white_jotter.admin.entity.Book;
import com.china.white_jotter.admin.entity.BookVo;
import com.china.white_jotter.admin.service.BookService;
import com.china.white_jotter.util.StringUtils;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @RequestMapping("api/covers")
    public String coversUpload(MultipartFile file) throws Exception{
        String folder = "E:/Resource/Learn/Git/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length()-4));
        if (!f.getParentFile().exists()){
            f.getParentFile().mkdirs();
        }
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8083/api/file/" + f.getName();
            return imgURL;
        }catch (IOException e){
            e.printStackTrace();
            return "";
        }
    }

}
