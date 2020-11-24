package com.china.white_jotter.admin.service.impl;

import com.china.white_jotter.admin.entity.AdminUserRole;
import com.china.white_jotter.admin.entity.AdminUserRoleExample;
import com.china.white_jotter.admin.mapper.AdminUserRoleMapper;
import com.china.white_jotter.admin.service.AdminUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author majiaju
 * @date
 */
@Service
public class AdminUserRoleServiceImpl implements AdminUserRoleService {
    @Resource
    AdminUserRoleMapper userRoleMapper;

    @Override
    public List<Integer> listAllByUid(Integer id) {
        AdminUserRoleExample example = new AdminUserRoleExample();
        AdminUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(id);
        List<AdminUserRole> userRoles = userRoleMapper.selectByExample(example);
        List<Integer> ids = new ArrayList<>();
        for (AdminUserRole userRole : userRoles){
            ids.add(userRole.getId());
        }
        return ids;
    }
}
