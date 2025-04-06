package com.mycompany.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println(readQuestionsFromForm());

        printMenuOptions();
        int chosenOption = getOptionFromUser();

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

    public static boolean isValidOption(int option){
        boolean isValid = option > 0 && option < 7;

        if(!isValid){
            System.out.print("Insira uma opção válida.\n");
        }

        return isValid;
    }

    public static void printMenuOptions(){
        System.out.print("1. Cadastrar um novo pet\n");
        System.out.print("2. Alterar dados do pet cadastrado\n");
        System.out.print("3. Deletar pet cadastrado\n");
        System.out.print("4. Listar todos os pets cadastrados\n");
        System.out.print("5. Listar pets por algum critério (idade, nome, raça)\n");
        System.out.print("6. Sair\n");
    }

    public static int getOptionFromUser(){
        Scanner sc = new Scanner(System.in);

        int res = 0;
        do {
            System.out.print("\nDigite a opção desejada: ");

            try {
                res = Integer.parseInt(sc.next());
            } catch (NumberFormatException ignored){}

        } while (!isValidOption(res));

        sc.close();

        return res;
    }
}
