package com.cybertek.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectDTO {
    private String projectName;
    private String projectCode;
    private UserDTO assignedManager;
    private LocalDate projectStartDate;
    private LocalDate projectEndDate;
}
