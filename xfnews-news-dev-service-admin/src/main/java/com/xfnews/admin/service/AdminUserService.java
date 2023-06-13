package com.xfnews.admin.service;

import com.xfnews.pojo.AdminUser;
import com.xfnews.pojo.bo.NewAdminBO;
import com.xfnews.utils.PagedGridResult;

public interface AdminUserService {

    /**
     * 获得管理员的用户信息
     */
    public AdminUser queryAdminByUsername(String username);

    /**
     * 新增管理员
     */
    public void createAdminUser(NewAdminBO newAdminBO);

    /**
     * 分页查询admin列表
     */
    public PagedGridResult queryAdminList(Integer page, Integer pageSize);

}
