package kr.java.sse_websocket.dto.api.response;

import kr.java.sse_websocket.entity.lesson.Lesson;
import kr.java.sse_websocket.entity.lesson.Subjects;

public record LessonResponse(
        Long id,
        String title,
        Subjects subjects,
        Long price,
        Double averageRating,
        String teacherName
) {
        public static LessonResponse from(Lesson lesson) {
                return new LessonResponse(
                        lesson.getId(),
                        lesson.getTitle(),
                        lesson.getSubjects(),
                        lesson.getPrice(),
                        lesson.getAverageRating(),
                        lesson.getUser().getName()
                );
        }
}
