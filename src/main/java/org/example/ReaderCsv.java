package org.example;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReaderCsv {
    public static Map<String, ArrayList<Building>> readCsv(String filePath)
    {
        Map<String, ArrayList<Building>> cityData = new HashMap<>();
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ";";
        try {
            br = new BufferedReader(new FileReader(filePath));
            if ((line = br.readLine()) != null) {
                // Пропуск заголовка
            }
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("\"", ""); // Удаляем кавычки из строки
                String partsOfLines[] = line.split(csvSplitBy);
                String city = partsOfLines[0].trim();
                String street = partsOfLines[1].trim();
                int house = Integer.parseInt(partsOfLines[2].trim());
                int floor = Integer.parseInt(partsOfLines[3].trim());
                //System.out.println(partsOfLines[3]);
                if (cityData.get(city) == null){
                    cityData.put(city, new ArrayList<Building>());
                }
                ArrayList arraylist = (ArrayList) cityData.get(city);
                arraylist.add(new Building(street, house, floor));
                cityData.put(city, arraylist);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Нет данного файла");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Количество городов: " + cityData.size());
        return cityData;
    }

}
