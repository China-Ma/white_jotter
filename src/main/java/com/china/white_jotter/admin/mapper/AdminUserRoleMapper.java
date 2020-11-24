package com.china.white_jotter.admin.mapper;

import com.china.white_jotter.admin.entity.AdminUserRole;
import com.china.white_jotter.admin.entity.AdminUserRoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AdminUserRoleMapper {
    long countByExample(AdminUserRoleExample example);

    int deleteByExample(AdminUserRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminUserRole record);

    int insertSelective(AdminUserRole record);

    List<AdminUserRole> selectByExample(AdminUserRoleExample example);

    AdminUserRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminUserRole record, @Param("example") AdminUserRoleExample example);

    int updateByExample(@Param("record") AdminUserRole record, @Param("example") AdminUserRoleExample example);

    int updateByPrimaryKeySelective(AdminUserRole record);

    int updateByPrimaryKey(AdminUserRole record);
}
