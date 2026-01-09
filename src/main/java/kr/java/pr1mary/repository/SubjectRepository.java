package kr.java.pr1mary.repository;

import kr.java.pr1mary.entity.lesson.Subject;
import kr.java.pr1mary.entity.lesson.Subjects;
import kr.java.pr1mary.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
//    @Query("SELECT s FROM Subject s WHERE s.user.id = :teacherId")
//    boolean existsByTeacherIdAndSubject(
//            @Param("teacherId") Long teacherId,
//            @Param("subject") String subject
//    ) {}

    boolean existsByUserAndSubjects(User user, Subjects subjects);
}
