package com.china.white_jotter.admin.service.impl;

import com.china.white_jotter.admin.entity.AdminRoleMenu;
import com.china.white_jotter.admin.entity.AdminRoleMenuExample;
import com.china.white_jotter.admin.mapper.AdminRoleMenuMapper;
import com.china.white_jotter.admin.service.AdminRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author majiaju
 * @date
 */
@Service
public class AdminRoleMenuServiceImpl implements AdminRoleMenuService {
    @Resource
    AdminRoleMenuMapper roleMenuMapper;

    @Override
    public List<Integer> findAllByRid(List<Integer> rids) {
        AdminRoleMenuExample example = new AdminRoleMenuExample();
        AdminRoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRidIn(rids);
        List<Integer> list = new ArrayList<>();
        for (AdminRoleMenu roleMenu:roleMenuMapper.selectByExample(example)){
            list.add(roleMenu.getMid());
        }
        return list;
    }
}
