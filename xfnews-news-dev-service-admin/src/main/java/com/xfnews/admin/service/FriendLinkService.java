package com.xfnews.admin.service;

import com.xfnews.pojo.AdminUser;
import com.xfnews.pojo.bo.NewAdminBO;
import com.xfnews.pojo.mo.FriendLinkMO;
import com.xfnews.utils.PagedGridResult;

import java.util.List;

public interface FriendLinkService {

    /**
     * 新增或者更新友情链接
     */
    public void saveOrUpdateFriendLink(FriendLinkMO friendLinkMO);

    /**
     * 查询友情链接
     */
    public List<FriendLinkMO> queryAllFriendLinkList();

    /**
     * 删除友情链接
     */
    public void delete(String linkId);

    /**
     * 首页查询友情链接
     */
    public List<FriendLinkMO> queryPortalAllFriendLinkList();
}
