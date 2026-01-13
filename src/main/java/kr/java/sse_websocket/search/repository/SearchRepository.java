package kr.java.sse_websocket.search.repository;

import kr.java.sse_websocket.search.document.LessonDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SearchRepository extends ElasticsearchRepository<LessonDocument, Long> {
    LessonDocument findByLessonId(Long lessonId);

    void deleteAll();
}
