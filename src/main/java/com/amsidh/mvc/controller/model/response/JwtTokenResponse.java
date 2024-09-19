package com.amsidh.mvc.controller.model.response;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class JwtTokenResponse implements Serializable {
    private String token;
}
