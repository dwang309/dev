package com.dw.view;

import java.time.LocalDate;

public interface EmployeeView {
    Integer getEmployeeId();

    String getFirstName();

    String getLastName();

    LocalDate getBirthday();

    String getEmailAddress();
}