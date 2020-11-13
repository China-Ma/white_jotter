package com.china.white_jotter.admin.service.impl;

import com.china.white_jotter.admin.entity.Category;
import com.china.white_jotter.admin.entity.CategoryExample;
import com.china.white_jotter.admin.mapper.CategoryMapper;
import com.china.white_jotter.admin.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author majiaju
 * @date
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryMapper categoryMapper;


    @Override
    public List<Category> list() {
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        return categoryMapper.selectByExample(example);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }
}
