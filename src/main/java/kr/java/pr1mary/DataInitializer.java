package kr.java.pr1mary;

import kr.java.pr1mary.dto.api.request.LessonRequest;
import kr.java.pr1mary.entity.lesson.Lesson;
import kr.java.pr1mary.entity.lesson.Subjects;
import kr.java.pr1mary.entity.user.TeacherProfile;
import kr.java.pr1mary.entity.user.User;
import kr.java.pr1mary.repository.TeacherProfileRepository;
import kr.java.pr1mary.repository.UserRepository;
import kr.java.pr1mary.search.service.SearchService;
import kr.java.pr1mary.service.LessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final LessonService lessonService;
    private final TeacherProfileRepository teacherProfileRepository;
    private final SearchService searchService;

    @Override
    @Transactional
    public void run(String... args) {
        if (userRepository.count() > 0) {
            log.info("데이터가 이미 존재합니다.");
            return;
        }

        log.info("테스트 데이터 초기화...");

        searchService.reset();

        User teacher = new User();
        teacher.setEmail("teacher@naver.com");
        teacher.setPassword("teacher123");
        teacher.setName("teacher");
        teacher.setAuth(User.Auth.LOCAL);
        teacher.setRole(User.Role.TEACHER);

        User student = new User();
        student.setEmail("student@naver.com");
        student.setPassword("student123");
        student.setName("student");
        student.setAuth(User.Auth.LOCAL);
        student.setRole(User.Role.STUDENT);

        User t = userRepository.save(teacher);
        userRepository.save(student);

        TeacherProfile teacherProfile = new TeacherProfile();
        teacherProfile.setUser(t);
        teacherProfile.setBio("hello");
        teacherProfile.setRegionCode("312");
        teacherProfile.setSchoolLevel(TeacherProfile.Level.HIGH);

        teacherProfileRepository.save(teacherProfile);

        LessonRequest lessonRequest = new LessonRequest();
        lessonRequest.setTitle("test1");
        lessonRequest.setDescription("test1");
        lessonRequest.setSubjects(Subjects.MATH);
        lessonRequest.setMode(Lesson.Mode.ONLINE);
        lessonRequest.setPrice(1000L);

        lessonService.saveLesson(lessonRequest, t.getId());

        LessonRequest lessonRequest2 = new LessonRequest();
        lessonRequest2.setTitle("test2");
        lessonRequest2.setDescription("test2");
        lessonRequest2.setSubjects(Subjects.ENGLISH);
        lessonRequest2.setMode(Lesson.Mode.OFFLINE);
        lessonRequest2.setPrice(1000L);

        lessonService.saveLesson(lessonRequest2, t.getId());

        log.info("초기화 완료!");
    }
}
