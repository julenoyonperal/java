package dev.lpa;

import dev.lpa.student.Course;
import dev.lpa.student.Student;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        String header = """
                Student Id,Country Code,Enrolled Year,Age,Gender,\
                Experienced,Course Code,Engagement Month,Engagement Year,\
                Engagement Type""";

        Course jmc = new Course("JMC", "Java Masterclass");
        Course pymc = new Course("PYC", "Python Masterclass");
        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(5)
                .toList();

//        System.out.println(header);
//        students.forEach(s -> s.getEngagementRecords().forEach(System.out::println));

        Path path = Path.of("students.csv");
//        try {
//            Files.writeString(path, header);
//            for (Student student : students) {
//                Files.write(path, student.getEngagementRecords(),
//                        StandardOpenOption.APPEND);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            List<String> data = new ArrayList<>();
            data.add(header);
            for (Student student : students) {
                data.addAll(student.getEngagementRecords());
            }
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer =
                     Files.newBufferedWriter(Path.of("take2.csv"))) {
            writer.write(header);
            writer.newLine();
            for (Student student : students) {
                for (var record : student.getEngagementRecords()) {
                    writer.write(record);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
