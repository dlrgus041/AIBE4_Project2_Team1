package kr.java.sse_websocket.entity.chat;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kr.java.sse_websocket.entity.BaseEntity;
import kr.java.sse_websocket.entity.user.User;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ChatRoom extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private User admin;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private User member;
}
