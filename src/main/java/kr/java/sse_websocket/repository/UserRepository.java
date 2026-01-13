package kr.java.sse_websocket.repository;

import kr.java.sse_websocket.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
