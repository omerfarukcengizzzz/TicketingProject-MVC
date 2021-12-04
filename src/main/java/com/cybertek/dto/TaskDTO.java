package com.cybertek.dto;

import com.cybertek.enums.Status;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {
    private ProjectDTO project;
    private String taskSubject;
    private UserDTO assignedEmployee;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate assignedDate;
    private Status status;
}
