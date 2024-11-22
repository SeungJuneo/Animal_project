package com.example.demo.module.notice;

import com.example.demo.module.notice.form.NoticeCreateForm;
import com.example.demo.module.notice.form.NoticeResponseForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class NoticeService {
    private final NoticeMapper noticeMapper;

    public NoticeBoard createNotice(NoticeCreateForm noticeCreateForm) {
        NoticeBoard noticeBoard = NoticeBoard.builder()
                .accountID(noticeCreateForm.getAccountID())
                .title(noticeCreateForm.getTitle())
                .image(noticeCreateForm.getImage())
                .animalType(noticeCreateForm.getAnimalType())
                .countrySiDo(noticeCreateForm.getCountrySiDo())
                .countryGunGu(noticeCreateForm.getCountryGunGu())
                .phoneNumber(noticeCreateForm.getPhoneNumber())
                .content(noticeCreateForm.getContent())
                .createdAt(LocalDateTime.now())
                .build();

        noticeMapper.createNotice(noticeBoard);
        return noticeBoard;
    }
    public List<NoticeResponseForm> getNotices() {
        return noticeMapper.getNotices();
    }

    public List<NoticeResponseForm> getNoticeAccount(long id) {
        return noticeMapper.getNoticeAccount(id);
    }

    public void deleteNotice(long id) {
        noticeMapper.deleteNotice(id);
    }

    public NoticeResponseForm getNotice(long noticeId) {
        return noticeMapper.getNotice(noticeId);
    }

    public List<NoticeResponseForm> getNoticesByFilter(NoticeCreateForm noticeCreateForm) {
        NoticeBoard noticeBoard = NoticeBoard.builder()
                .animalType(noticeCreateForm.getAnimalType())
                .countrySiDo(noticeCreateForm.getCountrySiDo())
                .build();
        return noticeMapper.getNoticesByFilter(noticeCreateForm);
    }
}
