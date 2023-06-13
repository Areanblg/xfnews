package com.xfnews.user.mapper;

import com.xfnews.my.mapper.MyMapper;
import com.xfnews.pojo.AppUser;
import com.xfnews.pojo.vo.PublisherVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AppUserMapperCustom {

    public List<PublisherVO> getUserList(Map<String, Object> map);

}