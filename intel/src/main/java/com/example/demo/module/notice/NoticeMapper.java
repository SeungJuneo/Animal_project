package com.example.demo.module.notice;

import com.example.demo.module.notice.form.NoticeCreateForm;
import com.example.demo.module.notice.form.NoticeResponseForm;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeMapper {
    @Insert("INSERT INTO notice_board(account_id, title, image, animal_type, country_sido, country_gungu, phone_number, content, created_at) " +
            "VALUES (#{accountID}, #{title}, #{image}, #{animalType},#{countrySiDo},#{countryGunGu},#{phoneNumber},#{content},#{createdAt});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createNotice(NoticeBoard noticeBoard);

    @Select("SELECT b.id, b.account_id, a.username, b.title, b.image, b.animal_type, b.country_sido, b.country_gungu, b.phone_number, b.content, b.created_at " +
            "FROM account a INNER JOIN notice_board b ON a.id = b.account_id " +
            "WHERE b.remove_fk = false;")
    List<NoticeResponseForm> getNotices();



    @Select("SELECT b.id, b.account_id, a.username, b.title, b.image, b.animal_type, b.country_sido, b.country_gungu, b.phone_number, b.content, b.created_at " +
            "FROM account a INNER JOIN notice_board b ON a.id = b.account_id " +
            "where b.account_id=#{id} and b.remove_fk=false")
    List<NoticeResponseForm> getNoticeAccount(long id);

    @Update("UPDATE notice_board set remove_fk=true, remove_at=now() where id=#{id}; ")
    void deleteNotice(long id);

    @Select("SELECT b.id, b.account_id, a.username, b.title, b.image, b.animal_type, b.country_sido, b.country_gungu, b.phone_number, b.content, b.created_at " +
            "FROM account a INNER JOIN notice_board b ON a.id = b.account_id " +
            "where b.id=#{noticeId} and b.remove_fk=false")
    NoticeResponseForm getNotice(long noticeId);

    @Select("SELECT b.id, b.account_id, a.username, b.title, b.image, b.animal_type, b.country_sido, b.country_gungu, b.phone_number, b.content, b.created_at " +
            "FROM account a INNER JOIN notice_board b ON a.id = b.account_id " +
            "where animal_type=#{animalType} and country_sido=#{countrySiDo} and b.remove_fk=false")
    List<NoticeResponseForm> getNoticesByFilter(NoticeCreateForm noticeCreateForm);
}


