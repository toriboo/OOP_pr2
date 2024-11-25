package org.example;
import java.util.Scanner;

public class Reader {
    private final Scanner scanner = new Scanner(System.in);

    public String readRequest() {
        System.out.print("Введите путь: ");
        String line = scanner.nextLine();
        if (line.equals("q")) // выйти когда нажато 'q'
        {
            System.exit(0);
        }
        return line;
    }
}
