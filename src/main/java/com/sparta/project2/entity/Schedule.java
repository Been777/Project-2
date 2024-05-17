package com.sparta.project2.entity;

import com.sparta.project2.dto.ScheduleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Schedule {
    private static long idCounter = 0;
    private Long id;
    private String title;
    private String contents;
    private String username;
    private String password;
    private String date;

    public Schedule(ScheduleRequestDto requestDto) {
        this.id = ++idCounter;
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.date = requestDto.getDate();
    }

    public void update(ScheduleRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }
}
