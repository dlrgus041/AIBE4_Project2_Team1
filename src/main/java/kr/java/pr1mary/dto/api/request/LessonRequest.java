package kr.java.pr1mary.dto.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import kr.java.pr1mary.entity.lesson.Lesson;
import kr.java.pr1mary.entity.lesson.Subjects;

public record LessonRequest(
        @NotBlank(message = "제목은 필수입니다")
        @Size(max = 100, message = "제목은 100자를 초과할 수 없습니다")
        String title,
        @NotBlank(message = "내용은 필수입니다")
        @Size(max = 2000, message = "제목은 2000자를 초과할 수 없습니다")
        String description,
        @NotBlank
        Subjects subjects,
        @NotBlank
        Lesson.Mode mode,
        Long price
) {

}
