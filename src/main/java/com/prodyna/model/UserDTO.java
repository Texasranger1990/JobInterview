package com.prodyna.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class UserDTO {
    private Integer id;
    private String fullName;
    private Gender gender;
    private Integer age;
}
