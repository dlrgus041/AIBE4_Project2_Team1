package websocket.controller.view;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import websocket.entity.CustomUserDetails;
import websocket.entity.lesson.Lesson;
import websocket.repository.LessonRepository;
import websocket.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingViewController {

    private final ScheduleService scheduleService;
    private final LessonRepository lessonRepository;

    // 예약 페이지
    @GetMapping("")
    public String bookingPage(
            @RequestParam(required = false) Long lessonId,
            @AuthenticationPrincipal CustomUserDetails userDetails,
            Model model) {

        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 수업입니다."));

        model.addAttribute("lessonId", lesson.getId());
        model.addAttribute("subject", lesson.getTitle()); // 수업 제목
        model.addAttribute("price", lesson.getPrice());   // 가격

        // 선생님 정보 (Lesson 안에 user 변수가 선생님입니다)
        model.addAttribute("teacherId", lesson.getUser().getId());
        model.addAttribute("teacherName", lesson.getUser().getName());
        // 날짜도 오늘 날짜로 가짜 생성
        model.addAttribute("dateStr", LocalDate.now().toString());

        // 3. 학생 정보 (로그인 기능 연동 전까지 임시 데이터)
        model.addAttribute("studentId", userDetails.getId());
        model.addAttribute("studentName", userDetails.getUsername());
        model.addAttribute("studentPhone", "010-1234-5678");

        return "pages/booking/booking-window";
    }

    // 수강 내역 조회 페이지 - 학생
    @GetMapping("/courseHistory")
    public String bookingHistoryPage(Model model, @AuthenticationPrincipal CustomUserDetails userDetails){
        // 1. HTML에서 사용할 studentId 필요
        model.addAttribute("studentId", userDetails.getId());
        // 2. 리턴하는 파일 이름
        return "pages/booking/courseHistory";
    }
}
