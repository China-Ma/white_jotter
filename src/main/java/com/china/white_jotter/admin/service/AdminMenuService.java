package com.china.white_jotter.admin.service;

import com.china.white_jotter.admin.entity.AdminMenu;

import java.util.List;

/**
 * @author majiaju
 * @date
 */
public interface AdminMenuService {

    List<AdminMenu> getMenusByCurrentUser();

    List<AdminMenu> getAllByParentId(Integer id);
}
