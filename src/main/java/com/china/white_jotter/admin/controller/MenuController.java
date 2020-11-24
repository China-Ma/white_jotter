package com.china.white_jotter.admin.controller;

import com.china.white_jotter.admin.entity.AdminMenu;
import com.china.white_jotter.admin.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author majiaju
 * @date
 */
@RestController
public class MenuController {

    @Autowired
    AdminMenuService menuService;

    @RequestMapping("/api/menu")
    public List<AdminMenu> menu(){
        return menuService.getMenusByCurrentUser();
    }
}
