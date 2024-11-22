package com.example.demo.module.notice.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NoticeResponseForm {
    private long id;
    private long accountID;
    private String username;
    private String title;
    private String image;
    private String animalType;
    private String countrySiDo;
    private String countryGunGu;
    private String phoneNumber;
    private String content;
    private LocalDateTime createdAt;
}
