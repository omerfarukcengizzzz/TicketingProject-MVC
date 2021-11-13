package com.cybertek.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectDTO {
    private String projectName;
    private String projectCode;
    private ManagerDTO assignedManager;
}
