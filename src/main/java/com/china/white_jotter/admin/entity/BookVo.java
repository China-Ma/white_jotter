package com.china.white_jotter.admin.entity;

/**
 * @author majiaju
 * @date
 */
public class BookVo extends Book{

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
