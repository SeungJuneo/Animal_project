package com.example.demo.module.notice;

import com.example.demo.module.notice.form.NoticeCreateForm;
import com.example.demo.module.notice.form.NoticeResponseForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping("/api/member/noticeboard")
    public ResponseEntity<?> createNotice(@RequestBody NoticeCreateForm noticeCreateForm){
        NoticeBoard noticeBoard = noticeService.createNotice(noticeCreateForm);
        return ResponseEntity.ok(noticeBoard);
    }

    @GetMapping("/api/common/noticeboard")
    public ResponseEntity<?> getNotices(){
        List<NoticeResponseForm> responseFormsList = noticeService.getNotices();
        return ResponseEntity.ok(responseFormsList);
    }
    @GetMapping("/api/common/noticeboard/filter")
    public ResponseEntity<?> searchNotices(@RequestBody NoticeCreateForm noticeCreateForm){
        List<NoticeResponseForm> responseFormsList = noticeService.getNoticesByFilter(noticeCreateForm);
        return ResponseEntity.ok(responseFormsList);
    }

    @GetMapping("/api/common/noticeboard/{id}")
    public ResponseEntity<?> getNotice(@PathVariable("id") long noticeId){
        NoticeResponseForm responseForm = noticeService.getNotice(noticeId);
        return ResponseEntity.ok(responseForm);
    }

    @GetMapping("/api/member/noticeboard/{id}")
    public ResponseEntity<?> getNoticeAccount(@PathVariable("id") long accountId){
        List<NoticeResponseForm> responseForm = noticeService.getNoticeAccount(accountId);
        return ResponseEntity.ok(responseForm);
    }

    @DeleteMapping("api/common/noticeboard/{id}")
    public ResponseEntity<?> deleteNotice(@PathVariable("id") long id){
        noticeService.deleteNotice(id);
        return ResponseEntity.ok(true); //만약 search되는 게 없으면 삭제할수 없습니다 출력(끝나고 심심하면)
    }
}
