package com.sparta.project2.dto;


import com.sparta.project2.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String username;
    private String date;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.username = schedule.getUsername();
        this.date = schedule.getDate();
    }
}