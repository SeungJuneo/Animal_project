package com.example.demo.module.reply.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReplyResponseForm {
    private long id;
    private long accountId;
    private String username;
    private long noticeId;
    private String content;
    private LocalDateTime createdAt;
}
