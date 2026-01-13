package kr.java.sse_websocket.repository;

import kr.java.sse_websocket.entity.user.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
}
