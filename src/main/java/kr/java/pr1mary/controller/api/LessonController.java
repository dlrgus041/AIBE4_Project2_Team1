package kr.java.pr1mary.controller.api;

import jakarta.validation.Valid;
import kr.java.pr1mary.dto.api.request.LessonRequest;
import kr.java.pr1mary.dto.api.response.LessonDetailResponse;
import kr.java.pr1mary.dto.api.response.LessonResponse;
import kr.java.pr1mary.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    // 과외 정보 조회
    @GetMapping("/detail/{lessonId}")
    public ResponseEntity<LessonDetailResponse> getLessonDetail(@PathVariable("lessonId") Long lessonId){
        return ResponseEntity.ok(lessonService.getLessonDetail(lessonId));
    }

    // 과외 생성
    @PostMapping
    public ResponseEntity<LessonResponse> create(@Valid @RequestBody LessonRequest request){
        // TODO: 유저 정보 가져오기
        LessonResponse response = lessonService.save(request, 1L);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // TODO: 선생님 별 과외 조회

    // TODO: 과외 정보 수정
    @PutMapping("/{lessonId}")
    public ResponseEntity<Void> updateLesson(@PathVariable("lessonId") Long lessonId){
        return ResponseEntity.noContent().build();
    }

    // TODO: 과외 삭제
    @DeleteMapping("/{lessonId}")
    public ResponseEntity<Void> deleteLesson(@PathVariable("lessonId") Long lessonId){
        return ResponseEntity.noContent().build();
    }
}
