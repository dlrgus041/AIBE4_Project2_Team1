package websocket.controller.view;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import websocket.dto.api.response.LessonDetailResponse;
import websocket.entity.CustomUserDetails;
import websocket.entity.lesson.Lesson;
import websocket.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonViewController {

    private final LessonService lessonService;

    // 과외 생성 페이지
    @GetMapping("/create")
    public String createForm(Model model, @AuthenticationPrincipal CustomUserDetails userDetails){
        model.addAttribute("teacherId", userDetails.getId());

        return "pages/lesson/create-form";
    }

    // 과외 수정 페이지
    @GetMapping("/update/{lessonId}")
    public String updateLesson(@PathVariable Long lessonId, Model model, @AuthenticationPrincipal CustomUserDetails userDetails){
        Lesson lesson = lessonService.getLesson(lessonId);

        model.addAttribute("teacherId", userDetails.getId());
        model.addAttribute("lesson", lesson);

        return "pages/lesson/update-form";
    }

    // 과외 상세 조회 페이지
    @GetMapping("/{id}")
    public String getLessonDetail(@PathVariable Long id, Model model){
        LessonDetailResponse response = lessonService.getLessonDetail(id);

        // 모델에 DTO 담기
        model.addAttribute("lesson", response);
        model.addAttribute("teacherName", "이코딩");

        return "pages/lesson/lesson-detail";
    }
}
