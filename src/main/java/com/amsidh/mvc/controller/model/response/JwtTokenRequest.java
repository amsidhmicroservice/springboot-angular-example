package com.amsidh.mvc.controller.model.response;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class JwtTokenRequest implements Serializable {

    private String username;
    private String password;
}
