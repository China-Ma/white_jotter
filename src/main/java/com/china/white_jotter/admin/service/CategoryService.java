package com.china.white_jotter.admin.service;

import com.china.white_jotter.admin.entity.Category;

import java.util.List;

/**
 * @author majiaju
 * @date
 */
public interface CategoryService {
    List<Category> list();

    Category get(int id);
}
