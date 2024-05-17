package com.sparta.project2.controller;

import com.sparta.project2.dto.ScheduleRequestDto;
import com.sparta.project2.dto.ScheduleResponseDto;
import com.sparta.project2.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final Map<Long, Schedule> scheduleList = new HashMap<>();


    @PostMapping("/schedule") // 일정 작성
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto);
        scheduleList.put(schedule.getId(), schedule);
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        return scheduleResponseDto;
    }
}