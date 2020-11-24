package com.china.white_jotter.admin.service.impl;

import com.china.white_jotter.admin.entity.*;
import com.china.white_jotter.admin.mapper.AdminMenuMapper;
import com.china.white_jotter.admin.service.AdminMenuService;
import com.china.white_jotter.admin.service.AdminRoleMenuService;
import com.china.white_jotter.admin.service.AdminUserRoleService;
import com.china.white_jotter.admin.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * @author majiaju
 * @date
 */
@Service
public class AdminMenuServiceImpl implements AdminMenuService {

    @Resource
    private AdminMenuMapper menuMapper;

    @Resource
    private LoginService loginService;

    @Resource
    private AdminUserRoleService userRoleService;

    @Resource
    private AdminRoleMenuService roleMenuService;

    @Override
    public List<AdminMenu> getMenusByCurrentUser() {
        // 从数据库中获取当前用户
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        Login login = loginService.getByUserName(username);

        // 获得当前用户对应的所有角色的id列表
        List<Integer> rids = userRoleService.listAllByUid(login.getId());

        // 查询出这些角色对应的多有菜单项
        List<Integer> menuIds = roleMenuService.findAllByRid(rids);
        AdminMenuExample example = new AdminMenuExample();
        AdminMenuExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(menuIds);
        return menuMapper.selectByExample(example);
    }


    public void handleMenus(List<AdminMenu> menus){
        for (AdminMenu menu : menus) {
            List<AdminMenu> childs = getAllByParentId(menu.getId());
            menu.setChilds(childs);
        }

        Iterator<AdminMenu> iterator = menus.iterator();
        while (iterator.hasNext()){
            AdminMenu menu = iterator.next();
            if (menu.getParentId() != 0){
                iterator.remove();
            }
        }
    }

    @Override
    public List<AdminMenu> getAllByParentId(Integer id) {
        AdminMenuExample example = new AdminMenuExample();
        AdminMenuExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(id);
        return menuMapper.selectByExample(example);
    }
}
