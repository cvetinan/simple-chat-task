package com.qaiware.interview.technicaltask.message.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "message_requests", indexes = {@Index(name = "type_index", columnList = "type"),
        @Index(name = "created_at_index", columnList = "created_at")})
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MessageRequest implements Serializable {
    private static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "payload")
    private String payload;
    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;

    /**
     * Generated from Wizard
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageRequest that = (MessageRequest) o;
        return Objects.equals(getId(), that.getId())
                && getType().equals(that.getType())
                && getPayload().equals(that.getPayload())
                && Objects.equals(getCreatedAt(), that.getCreatedAt());
    }

    /**
     * Generated from Wizard
     */
    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getType().hashCode();
        result = 31 * result + getPayload().hashCode();
        result = 31 * result + (getCreatedAt() != null ? getCreatedAt().hashCode() : 0);
        return result;
    }
}
