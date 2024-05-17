package com.sparta.project2.controller;

import ch.qos.logback.core.net.SMTPAppenderBase;
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

    @GetMapping("/schedule") // 일정 목록 조회
    public List<ScheduleResponseDto> getSchedule() {
        List<ScheduleResponseDto> responseList = scheduleList.values().stream()
                .map(ScheduleResponseDto::new).toList();

        return responseList;
    }

    @PutMapping("/schedule/{id}") // 선택한 일정 수정
    public Long updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        if(scheduleList.containsKey(id)) {
            Schedule schedule = scheduleList.get(id);
            if (!requestDto.getPassword().equals(schedule.getPassword())) {
                throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
            }
            schedule.update(requestDto);
            return schedule.getId();
        } else {
            throw new IllegalArgumentException("선택한 일정은 존재하지 않습니다.");
        }
    }

    @DeleteMapping("/schedule/{id}") // 선택한 일정 삭제
    public Long deleteSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        if(scheduleList.containsKey(id)) {
            if (schedule.getPassword().equals(requestDto.getPassword())) {
                // 일치하면 일정 삭제
                scheduleList.remove(id);
                return id;
            } else {
                throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
            }
        } else {
            throw new IllegalArgumentException("선택한 일정은 존재하지 않습니다.");
        }
    }
}