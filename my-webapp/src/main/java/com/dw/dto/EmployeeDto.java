package com.dw.dto;

import com.dw.domain.Employee;
import lombok.Setter;

import java.time.LocalDate;

@Setter
public class EmployeeDto {

    private Integer employeeId;

    private String firstName;

    private String lastName;

    private LocalDate birthday;

    private String emailAddress;

}
