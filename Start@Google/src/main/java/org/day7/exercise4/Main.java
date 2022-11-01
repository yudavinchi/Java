package org.day7.exercise4;

import org.day7.exercise4.jobPosition.JobPosition;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        JobPosition jobPosition = new JobPosition.Builder(LocalDate.now(), "Backend edeveloper", true).build();
    }
}
