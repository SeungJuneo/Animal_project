package com.example.demo.module.notice;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NoticeBoard {
    private long id;
    private long accountID;
    private String title;
    private String image;
    private String animalType;
    private String countrySiDo;
    private String countryGunGu;
    private String phoneNumber;
    private String content;
    private int viewerCount;
    private LocalDateTime createdAt;
    private boolean removeFk;
    private LocalDateTime removeAt;
}
