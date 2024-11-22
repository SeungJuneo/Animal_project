package com.example.demo.module.notice.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeCreateForm {
    private long accountID;
    private String title;
    private String image;
    private String animalType;
    private String countrySiDo;
    private String countryGunGu;
    private String phoneNumber;
    private String content;
}