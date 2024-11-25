package org.example;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Map<String, ArrayList<Building>> cityData;
        System.out.println("Введите q для завершения");
        while (true) {
            String filePath = readFilePath();
            if (filePath.endsWith(".csv")) {
                ReaderCsv readerCsv = new ReaderCsv();
                readerCsv.readCsv(filePath);
            }
            else if (filePath.endsWith(".xml")) {
                ReaderXml readerXml= new ReaderXml();
                readerXml.readXml(filePath);
            }
            else {
                System.out.println("Неподдерживаемы формат");
            }

        }

    }
    private static String readFilePath(){
        Reader reader = new Reader();
        return reader.readRequest();
    }
}