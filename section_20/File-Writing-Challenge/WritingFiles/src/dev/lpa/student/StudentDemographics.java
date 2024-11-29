package dev.lpa.student;

import java.util.StringJoiner;

public record StudentDemographics(String countryCode, int enrolledMonth,
                                  int enrolledYear, int ageAtEnrollment, String gender,
                                  boolean previousProgrammingExperience ) {

    @Override
    public String toString() {
        return "%s,%d,%d,%d,%s,%b".formatted(countryCode,
                enrolledMonth,enrolledYear, ageAtEnrollment,gender,
                previousProgrammingExperience);
    }

    public String toJSON() {
        return new StringJoiner(", ", "{", "}")
                .add("\"countryCode\":\"" + countryCode + "\"")
                .add("\"enrolledMonth\":" + enrolledMonth)
                .add("\"enrolledYear\":" + enrolledYear)
                .add("\"ageAtEnrollment\":" + ageAtEnrollment)
                .add("\"gender\":\"" + gender + "\"")
                .add("\"previousProgrammingExperience\":" + previousProgrammingExperience)
                .toString();
    }
}
