package com.prodyna.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiUserDTO {
    private Integer id;
    private String forename;
    private String lastName;
    private String dateOfBirth;
    private String gender;
}