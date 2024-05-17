package com.sparta.project2.controller;

import com.sparta.project2.dto.ScheduleRequestDto;
import com.sparta.project2.dto.ScheduleResponseDto;
import com.sparta.project2.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    @GetMapping("/schedule/{id}") // 선택한 일정 조회
    public ScheduleResponseDto getSchedule(@PathVariable Long id) {
        Schedule schedule = scheduleList.get(id);
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        return scheduleResponseDto;
    }


//    @GetMapping("/schedule") // 일정 목록 조회
//    public List<ScheduleResponseDto> getSchedule() {
//        List<ScheduleResponseDto> responseList = scheduleList.values().stream()
//                .map(ScheduleResponseDto::new).toList();
//
//        return responseList;
//    }
//}