package com.example.demo.module.reply;

import com.example.demo.module.reply.form.ReplyResponseForm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReplyMapper {

    @Select("SELECT b.id, b.account_id, a.username, b.notice_id, b.content, b.created_at " +
            "FROM account a " +
            "INNER JOIN reply b ON a.id = b.account_id " +
            "INNER JOIN notice_board c ON b.notice_id = c.id " +
            "WHERE b.notice_id = #{noticeId} AND c.remove_fk = false;")
    List<ReplyResponseForm> getReply(long noticeId);



    @Insert("INSERT INTO reply(account_id, notice_id, content, created_at) " +
            "VALUES(#{accountId}, #{noticeId}, #{content}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createReply(Reply reply);
}
