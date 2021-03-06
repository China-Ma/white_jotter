package com.china.white_jotter.admin.mapper;

import com.china.white_jotter.admin.entity.AdminRoleMenu;
import com.china.white_jotter.admin.entity.AdminRoleMenuExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AdminRoleMenuMapper {
    long countByExample(AdminRoleMenuExample example);

    int deleteByExample(AdminRoleMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminRoleMenu record);

    int insertSelective(AdminRoleMenu record);

    List<AdminRoleMenu> selectByExample(AdminRoleMenuExample example);

    AdminRoleMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminRoleMenu record, @Param("example") AdminRoleMenuExample example);

    int updateByExample(@Param("record") AdminRoleMenu record, @Param("example") AdminRoleMenuExample example);

    int updateByPrimaryKeySelective(AdminRoleMenu record);

    int updateByPrimaryKey(AdminRoleMenu record);
}
