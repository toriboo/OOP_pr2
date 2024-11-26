package org.example;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, ArrayList<Building>> cityData;
        System.out.println("Введите q для завершения");
        while (true) {
            String filePath = readFilePath();
            if (filePath.endsWith(".csv")) {
                ReaderCsv readerCsv = new ReaderCsv();
                showStatistics(readerCsv.readCsv(filePath));
            }
            else if (filePath.endsWith(".xml")) {
                ReaderXml readerXml= new ReaderXml();
                showStatistics(readerXml.readXml(filePath));
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

    private static  void showStatistics(Map<String, ArrayList<Building>> cityData){
        Statistics statistics  = new Statistics();
        statistics.displayInfo(cityData);
    }
}