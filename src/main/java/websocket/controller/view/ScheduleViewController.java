package websocket.controller.view;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import websocket.dto.api.response.TeacherScheduleResponse;
import websocket.entity.CustomUserDetails;
import websocket.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// 선생님 시간표 조회
@Controller
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class ScheduleViewController {
    private final ScheduleService scheduleService;

    // 선생님 페이지 - 시간표 관리 화면
    @GetMapping("/timetable")
    public String teacherTimetable(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
        Long currentTeacherId = userDetails.getId();

        List<TeacherScheduleResponse> schedules = scheduleService.getTeacherSchedules(currentTeacherId);

        model.addAttribute("schedules", schedules);

        return "pages/schedule/teacher-timetable";
    }
}
