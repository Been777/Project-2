package com.sparta.project2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScheduleRequestDto {
    private String title;
    private String contents;
    private String username;
    private String password;
    private String date;
}