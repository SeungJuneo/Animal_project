package com.example.demo.module.reply;

import com.example.demo.module.reply.form.ReplyCreateForm;
import com.example.demo.module.reply.form.ReplyResponseForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ReplyService {
    private final ReplyMapper replyMapper;
    public List<ReplyResponseForm> getReply(long noticeId){
        return replyMapper.getReply(noticeId);
    }

    public Reply createReply(ReplyCreateForm replyCreateForm, long accountId) {
        Reply reply = Reply.builder()
                .accountId(accountId)
                .noticeId(replyCreateForm.getNoticeId())
                .content(replyCreateForm.getContent())
                .createdAt(LocalDateTime.now())
                .build();

        replyMapper.createReply(reply);
        return reply;
    }
}
