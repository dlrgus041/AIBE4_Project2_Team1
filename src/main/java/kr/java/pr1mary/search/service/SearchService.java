package kr.java.pr1mary.search.service;

import kr.java.pr1mary.entity.lesson.Lesson;
import kr.java.pr1mary.search.document.LessonDocument;
import kr.java.pr1mary.search.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final SearchRepository searchRepository;

    public List<LessonDocument> searchByKeyword(String keyword) {
        List<LessonDocument> results = searchRepository.findByLessonNameContaining(keyword);

        List<LessonDocument> results2 = searchRepository.findByTeacherNameContaining(keyword);
        results.addAll(results2);

        return results;
    }

    public void saveDocument(Lesson lesson){
        LessonDocument lessonDocument = LessonDocument.from(lesson);
        searchRepository.save(lessonDocument);
    }

    public void updateDocument(Lesson lesson){
        LessonDocument existingDocument = searchRepository.findByLessonId(lesson.getId());

        existingDocument.setLessonName(lesson.getTitle());
        existingDocument.setSubject(lesson.getSubjects().toString());
        existingDocument.setAverageRating(lesson.getAverageRating());
        existingDocument.setPrice(lesson.getPrice());

        searchRepository.save(existingDocument);
    }

    public void reset(){
        searchRepository.deleteAll();
    }

    public void deleteDocument(Long lessonId){
        LessonDocument lessonDocument = searchRepository.findByLessonId(lessonId);
        searchRepository.delete(lessonDocument);
    }
}
