package com.amsidh.mvc.controller.model.response;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class HelloWorldBean implements Serializable {
    private String message;
}
