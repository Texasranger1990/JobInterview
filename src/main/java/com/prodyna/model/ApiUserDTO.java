package com.prodyna.model;

import lombok.*;

@NoArgsConstructor
@Getter
public class ApiUserDTO {
    private Integer id;
    private String forename;
    private String lastName;
    private String dateOfBirth;
    private String gender;
}