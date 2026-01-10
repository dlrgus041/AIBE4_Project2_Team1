package kr.java.pr1mary.controller.api;

import kr.java.pr1mary.dto.view.ReviewDTO;
import kr.java.pr1mary.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class LoadReviewController {
    private final ReviewService reviewService;

    // 학생이 작성한 리뷰 불러오기
    @GetMapping("/student")
    public ResponseEntity<List<ReviewDTO>> getStudentReview(@RequestParam("id") Long studentId) {
        List<ReviewDTO> reviews = reviewService.loadReviewByStudent(studentId);
        return ResponseEntity.ok(reviews);
    }

    // 교사에게 작성된 리뷰 불러오기
    @GetMapping("/teacher")
    public ResponseEntity<List<ReviewDTO>> getteacherReview(@RequestParam("id") Long teacherId) {
        List<ReviewDTO> reviews = reviewService.loadReviewAboutTeacher(teacherId);
        return ResponseEntity.ok(reviews);
    }

    // 수업에 작성된 리뷰 불러오기
    @GetMapping("/lesson")
    public ResponseEntity<List<ReviewDTO>> getLessonReview(@RequestParam("id") Long lessonId) {
        List<ReviewDTO> reviews = reviewService.loadReviewAboutLesson(lessonId);
        return ResponseEntity.ok(reviews);
    }
}
