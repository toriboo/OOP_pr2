package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Statistics {
    public void displayInformation(Map<String, ArrayList<Building>> cityData){
        if(!cityData.isEmpty()) {
            System.out.println("Дублирующиеся записи:");
            for (String city : cityData.keySet()) { // перебираем все города в HashMap
                final int SIZE_ARRAY = 5;
                int[] countFloor = new int[SIZE_ARRAY]; // массив для подсчета n- этажных зданий
                Map<String, Integer> buildingCount = new HashMap<>(); // создаем новый HashMap для подсчета повторений адресов в городе
                ArrayList<Building> arraylist = cityData.get(city); // получаем массив адрессов в городе
                for (int i = 0; i < arraylist.size(); i++) { // перебираем каждый адресс
                    if (buildingCount.get(arraylist.get(i).getAddress()) == null) { // если в новом HashMap нет такого адреса
                        buildingCount.put(arraylist.get(i).getAddress(), 1); // устанавливаем кол-во повртерений 1
                    } else {
                        int count = buildingCount.get(arraylist.get(i).getAddress()) + 1; // устанваливаем кол-во повтренений
                        buildingCount.put(arraylist.get(i).getAddress(), count);
                    }
                    if ((arraylist.get(i).getFloor()) <= 5 && (arraylist.get(i).getFloor()) >= 0) {
                        countFloor[(arraylist.get(i).getFloor()) - 1]++; // увеличиваем кол-во n-этажных зданий
                    }
                }
                for (String buildings : buildingCount.keySet()) { // для всех уникальных адрессов
                    if (buildingCount.get(buildings) > 1) { // если есть дубликаты
                        System.out.println(city + ": " + buildings + " Количество повторений:" + buildingCount.get(buildings));
                        char lastChar = buildings.charAt(buildings.length() - 1);
                        int floor = Character.getNumericValue(lastChar);
                        countFloor[floor - 1] = countFloor[floor - 1] - buildingCount.get(buildings);
                    }
                }
                System.out.println("Здания в городе " + city + ":");
                for (int i = 0; i < SIZE_ARRAY; i++) {
                    int k = i + 1;
                    System.out.println("Количество " + k + "-этажных: " + countFloor[i]);
                }
            }
        }

    }
}
