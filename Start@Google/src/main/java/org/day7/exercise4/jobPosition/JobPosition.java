package org.day7.exercise4.jobPosition;

import java.time.LocalDate;

public class JobPosition {

    private final LocalDate publishedDate;
    private final String title;
    private final boolean isRemote;
    private String description;
    private String location;
    private int salaryCap;
    private int yearsOfExperienceRequired;

    public static class Builder {
        //Required Parameters
        private final LocalDate publishedDate;
        private final String title;
        private final boolean isRemote;

        //Optional Parameters
        private String description;
        private String location = "Tel-Aviv";
        private int salaryCap = 10000;
        private int yearsOfExperienceRequired = 0;

        public Builder(LocalDate publishedDate, String title, boolean isRemote) {
            this.publishedDate = publishedDate;
            this.title = title;
            this.isRemote = isRemote;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder salaryCap(int salaryCap) {
            this.salaryCap = salaryCap;
            return this;
        }

        public Builder yearsOfExperienceRequired(int yearsOfExperienceRequired) {
            this.yearsOfExperienceRequired = yearsOfExperienceRequired;
            return this;
        }

        public JobPosition build() {
            return new JobPosition(this);
        }
    }

    private JobPosition(Builder builder) {
        this.publishedDate = builder.publishedDate;
        this.title = builder.title;
        this.isRemote = builder.isRemote;
        this.description = builder.description;
        this.location = builder.location;
        this.salaryCap = builder.salaryCap;
        this.yearsOfExperienceRequired = builder.yearsOfExperienceRequired;
    }
}
