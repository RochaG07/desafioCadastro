package com.mycompany.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println(readQuestionsFromForm());
    }

    public static String readQuestionsFromForm(){
        String path = new File("").getAbsoluteFile() + "\\src\\main\\resources\\formulario.txt";

        StringBuilder questions = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;

            while((line = br.readLine()) != null){
                questions.append(line);
                questions.append(System.lineSeparator());
                questions.append(System.lineSeparator());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return questions.toString();
    }
}
