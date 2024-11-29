package dev.lpa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        System.out.println("Current Working Directory (cwd) = " +
                new File("").getAbsolutePath());

        String filename = "files/testing.csv";

        File file = new File(new File("").getAbsolutePath(), filename);
        System.out.println(file.getAbsolutePath());
        if (!file.exists()) {
            System.out.println("I can't run unless this file exists");
            return;
        }
        System.out.println("I'm good to go.");

        for (File f : File.listRoots()) {
            System.out.println(f);
        }

        Path path = Paths.get("files/testing.csv");
        System.out.println(file.getAbsolutePath());
        if (!Files.exists(path)) {
            System.out.println("2. I can't run unless this file exists");
            return;
        }
        System.out.println("2. I'm good to go.");

    }

    private static void testFile(String filename) {

        Path path = Paths.get(filename);
        FileReader reader = null;
        try {
//            List<String> lines = Files.readAllLines(path);
            reader = new FileReader(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Maybe I'd log something either way...");
        }
        System.out.println("File exists and able to use as a resource");
    }

    private static void testFile2(String filename) {

        try (FileReader reader = new FileReader(filename)) {
        } catch (FileNotFoundException e) {
            System.out.println("File '" + filename + "' does not exist");
            throw new RuntimeException(e);
        } catch (NullPointerException | IllegalArgumentException badData) {
            System.out.println("User has added bad data " + badData.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Something unrelated and unexpected happened");
        } finally {
            System.out.println("Maybe I'd log something either way...");
        }
        System.out.println("File exists and able to use as a resource");
    }
}
