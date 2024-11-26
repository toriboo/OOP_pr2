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
                long startTime = System.currentTimeMillis();;
                ReaderCsv readerCsv = new ReaderCsv();
                showStatistics(readerCsv.readCsv(filePath));
                System.out.println("Время обработки " + processingTime(startTime) + " мс");
            }
            else if (filePath.endsWith(".xml")) {
                long startTime = System.currentTimeMillis();
                ReaderXml readerXml= new ReaderXml();
                showStatistics(readerXml.readXml(filePath));
                System.out.println("Время обработки " + processingTime(startTime) + " мс");
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
        statistics.displayInformation(cityData);
    }
    public static long processingTime(long start) {
        return (System.currentTimeMillis()- start);
    }
}