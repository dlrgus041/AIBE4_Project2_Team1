package kr.java.pr1mary.search.repository;

import kr.java.pr1mary.search.document.LessonDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface SearchRepository extends ElasticsearchRepository<LessonDocument, Long> {
    List<LessonDocument> findByLessonNameContaining(String lessonName);
    List<LessonDocument> findByTeacherNameContaining(String teacherName);

    LessonDocument findByLessonId(Long lessonId);
}
