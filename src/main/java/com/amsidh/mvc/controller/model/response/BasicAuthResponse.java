package com.amsidh.mvc.controller.model.response;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class BasicAuthResponse implements Serializable {
    private String message;
}
