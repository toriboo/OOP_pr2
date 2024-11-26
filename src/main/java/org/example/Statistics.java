package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Statistics {
    public void displayInfo(Map<String, ArrayList<Building>> cityData){
        System.out.println("Дублирующиеся записи:");
        for (String city : cityData.keySet()){ // перебираем все города в HashMap
            Map<String, Integer> buildingCount = new HashMap<>(); // создаем новый HashMap для подсчета повторений адресов в городе
            ArrayList<Building> arraylist = cityData.get(city); // получаем массив адрессов в городе
            for (int i = 0; i < arraylist.size(); i ++){ // перебираем каждый адресс
                if (buildingCount.get(arraylist.get(i).getAddress()) == null ){ // если в новом HashMap нет такого адреса
                    buildingCount.put(arraylist.get(i).getAddress(), 1); // устанавливаем кол-во повртерений 1
                }
                else {
                    int count = buildingCount.get(arraylist.get(i).getAddress()) + 1; // устанваливаем кол-во повтренений
                    buildingCount.put(arraylist.get(i).getAddress(), count);
                }

            }
            for (String buildings : buildingCount.keySet() ){ // для всех уникальных адрессов
                if (buildingCount.get(buildings) > 1){ // если есть дубликаты
                    System.out.println(city+ ": " + buildings +  " Количество повторений:" + buildingCount.get(buildings));
                }
            }


        }
    }
}
