package org.example;
import java.util.Scanner;

public class Reader {
    private final Scanner scanner = new Scanner(System.in);

    public String readRequest() {
        System.out.print("Введите путь: ");
        return scanner.nextLine();
    }
}
