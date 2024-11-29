package dev.lpa;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

record Student(String name, int enrolledYear, int studentId)
        implements Comparable<Student> {

    @Override
    public int compareTo(Student o) {
        return this.studentId - o.studentId;
    }
}

class StudentId {

    private int id = 0;

    public int getId() {
        return id;
    }

    public synchronized int getNextId() {
        return ++id;
    }
}

class AtomicStudentId {

    private final AtomicInteger nextId = new AtomicInteger(0);

    public int getId() {
        return nextId.get();
    }

    public int getNextId() {
        return nextId.incrementAndGet();
    }
}

public class Main {

    private static Random random = new Random();

    private static ConcurrentSkipListSet<Student> studentSet =
            new ConcurrentSkipListSet<>();

    public static void main(String[] args) {

        AtomicStudentId idGenerator = new AtomicStudentId();
        Callable<Student> studentMaker = () -> {
            int studentId = idGenerator.getNextId();
            Student student = new Student("Tim " + studentId,
                    random.nextInt(2018, 2025), studentId);
            studentSet.add(student);
            return student;
        };

        var executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            studentSet.clear();
            try {
                var futures = executor.invokeAll(
                        Collections.nCopies(10, studentMaker));
                System.out.println("# of students = " + studentSet.size());
//                studentSet.forEach(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executor.shutdown();
    }
}
