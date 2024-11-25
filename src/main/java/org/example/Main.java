package org.example;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        char ch ;
        int code ;
        Map<String, ArrayList<Building>> cityData;
        while (true) {
            try {
                if (!(-1 != (code = System.in.read()))) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ch = (char) code;
            if ('q' == ch) // выйти когда нажато 'q'
            {
                System.exit(0);
            }
            String filePath = readFilePath();
            if (filePath.endsWith(".csv")) {
                ReaderCsv readerCsv = new ReaderCsv();
                readerCsv.readCsv(filePath);
            } else {
                System.out.println("Неподдерживаемы формат");

            }
        }



    }
    private static String readFilePath(){
        Reader reader = new Reader();
        return reader.readRequest();
    }
}