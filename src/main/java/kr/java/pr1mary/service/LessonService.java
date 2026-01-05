package kr.java.pr1mary.service;

import jakarta.persistence.EntityNotFoundException;
import kr.java.pr1mary.dto.api.request.LessonRequest;
import kr.java.pr1mary.dto.api.response.LessonDetailResponse;
import kr.java.pr1mary.dto.api.response.LessonResponse;
import kr.java.pr1mary.entity.lesson.Lesson;
import kr.java.pr1mary.entity.user.User;
import kr.java.pr1mary.repository.LessonRepository;
import kr.java.pr1mary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;
    private final UserRepository userRepository;

    public LessonResponse save(LessonRequest lessonRequest, Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("사용자를 찾을 수 없습니다."));

        Lesson lesson = Lesson.create(lessonRequest, user);
        Lesson saved = lessonRepository.save(lesson);

        return LessonResponse.from(saved);
    }

    public LessonDetailResponse getLessonDetail(Long lessonId){
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new EntityNotFoundException("과외를 찾을 수 없습니다."));

        return LessonDetailResponse.from(lesson);
    }
}
