package com.example.demo.module.reply;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
    private long id;
    private long accountId;
    private long noticeId;
    private String content;
    private LocalDateTime createdAt;
}
