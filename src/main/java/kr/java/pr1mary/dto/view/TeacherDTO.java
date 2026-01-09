package kr.java.pr1mary.dto.view;

import kr.java.pr1mary.entity.lesson.Subjects;
import kr.java.pr1mary.entity.user.TeacherProfile;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class TeacherDTO {
    private Long id;
    private MultipartFile image;
    private String introduce;
    private Subjects subjects;
}
