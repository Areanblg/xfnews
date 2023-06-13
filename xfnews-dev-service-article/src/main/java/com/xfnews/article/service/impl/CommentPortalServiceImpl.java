package com.xfnews.article.service.impl;

import com.github.pagehelper.PageHelper;
import com.xfnews.api.controller.article.CommentControllerApi;
import com.xfnews.api.service.BaseService;
import com.xfnews.article.mapper.ArticleMapper;
import com.xfnews.article.mapper.CommentsMapper;
import com.xfnews.article.mapper.CommentsMapperCustom;
import com.xfnews.article.service.ArticlePortalService;
import com.xfnews.article.service.CommentPortalService;
import com.xfnews.enums.ArticleReviewStatus;
import com.xfnews.enums.YesOrNo;
import com.xfnews.pojo.Article;
import com.xfnews.pojo.Comments;
import com.xfnews.pojo.vo.ArticleDetailVO;
import com.xfnews.pojo.vo.CommentsVO;
import com.xfnews.utils.PagedGridResult;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentPortalServiceImpl extends BaseService implements CommentPortalService {

    @Autowired
    private Sid sid;

    @Autowired
    private ArticlePortalService articlePortalService;

    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private CommentsMapperCustom commentsMapperCustom;

    @Transactional
    @Override
    public void createComment(String articleId,
                                                 String fatherCommentId,
                                                 String content,
                                                 String userId,
                                                 String nickname,
                                                 String face) {

        String commentId = sid.nextShort();

        ArticleDetailVO article
                 = articlePortalService.queryDetail(articleId);

        Comments comments = new Comments();
        comments.setId(commentId);

        comments.setWriterId(article.getPublishUserId());
        comments.setArticleTitle(article.getTitle());
        comments.setArticleCover(article.getCover());
        comments.setArticleId(articleId);

        comments.setFatherId(fatherCommentId);
        comments.setCommentUserId(userId);
        comments.setCommentUserNickname(nickname);
        comments.setCommentUserFace(face);

        comments.setContent(content);
        comments.setCreateTime(new Date());

        commentsMapper.insert(comments);

        // 评论数累加
        redis.increment(REDIS_ARTICLE_COMMENT_COUNTS + ":" + articleId, 1);
    }

    @Override
    public PagedGridResult queryArticleComments(String articleId,
                                                Integer page,
                                                Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("articleId", articleId);

        PageHelper.startPage(page, pageSize);
        List<CommentsVO> list = commentsMapperCustom.queryArticleCommentList(map);
        return setterPagedGrid(list, page);
    }

    @Override
    public PagedGridResult queryWriterCommentsMng(String writerId, Integer page, Integer pageSize) {

        Comments comment = new Comments();
        comment.setWriterId(writerId);

        PageHelper.startPage(page, pageSize);
        List<Comments> list = commentsMapper.select(comment);
        return setterPagedGrid(list, page);
    }

    @Override
    public void deleteComment(String writerId, String commentId) {
        Comments comment = new Comments();
        comment.setId(commentId);
        comment.setWriterId(writerId);

        commentsMapper.delete(comment);
    }
}
