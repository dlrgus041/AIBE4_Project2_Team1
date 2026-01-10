package kr.java.pr1mary.repository;

import kr.java.pr1mary.entity.user.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
}
