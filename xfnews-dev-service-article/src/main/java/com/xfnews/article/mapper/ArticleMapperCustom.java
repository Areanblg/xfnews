package com.xfnews.article.mapper;

import com.xfnews.my.mapper.MyMapper;
import com.xfnews.pojo.Article;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleMapperCustom extends MyMapper<Article> {

    public void updateAppointToPublish();

}