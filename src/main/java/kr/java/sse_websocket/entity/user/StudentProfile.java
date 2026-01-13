package kr.java.sse_websocket.entity.user;

import jakarta.persistence.*;
import kr.java.sse_websocket.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StudentProfile extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String bio;

    @Column(nullable = false)
    private String regionCode;

    @Column(name = "image_url")
    private String imageUrl;
}
