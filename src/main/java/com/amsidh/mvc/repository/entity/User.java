package com.amsidh.mvc.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@Table(name = "USER_INFO")
public class User implements Serializable {

    @Id
    private String username;

    @ElementCollection
    @CollectionTable(
            name = "USER_TODO",  // The table where the list will be stored
            joinColumns = @JoinColumn(name = "username")
    )
    List<Todo> todos;
}
