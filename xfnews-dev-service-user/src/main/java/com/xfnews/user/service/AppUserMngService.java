package com.xfnews.user.service;

import com.xfnews.pojo.AppUser;
import com.xfnews.pojo.bo.UpdateUserInfoBO;
import com.xfnews.utils.PagedGridResult;

import java.util.Date;

public interface AppUserMngService {

    /**
     * 查询管理员列表
     */
    public PagedGridResult queryAllUserList(String nickname,
                                            Integer status,
                                            Date startDate,
                                            Date endDate,
                                            Integer page,
                                            Integer pageSize);

    /**
     * 冻结用户账号，或者解除冻结状态
     */
    public void freezeUserOrNot(String userId, Integer doStatus);

}
