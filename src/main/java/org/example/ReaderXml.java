package org.example;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReaderXml {
    public static Map<String, ArrayList<Building>> readXml(String filePath)  {
        Map<String, ArrayList<Building>> cityData = new HashMap<>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                String city;
                String street;
                int house;
                int floor;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("item")) {
                        city = attributes.getValue("city");
                        street = attributes.getValue("street");
                        house = Integer.parseInt(attributes.getValue("house"));
                        floor = Integer.parseInt(attributes.getValue("floor"));

                        if (cityData.get(city) == null){
                            cityData.put(city, new ArrayList<Building>());
                        }
                        ArrayList arraylist = (ArrayList) cityData.get(city);
                        arraylist.add(new Building(street, house, floor));
                        cityData.put(city, arraylist);
                    }
                }
            };
            saxParser.parse(new File(filePath), handler);
        }
        catch (FileNotFoundException e) {
            System.out.println("Нет данного файла");

        }catch (Exception e) {
            e.printStackTrace();
        }
        return cityData;
    }
}
