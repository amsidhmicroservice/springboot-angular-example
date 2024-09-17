package com.amsidh.mvc.repository.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Embeddable
public class Todo implements Serializable {
    private Integer todoId;
    private String description;
    private Boolean isDone;
    private Date targetDate;
}
