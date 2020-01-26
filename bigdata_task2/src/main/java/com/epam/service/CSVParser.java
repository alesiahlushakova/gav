package com.epam.service;

import com.epam.entity.Location;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

        public  List<Location> parseProductCsv(String filePath) throws IOException {

            List<Location> locations = new ArrayList<>();
            List<String> fileLines = Files.readAllLines(Paths.get(filePath));
            for (String fileLine : fileLines) {
                String[] splitedText = fileLine.split(",");
                ArrayList<String> columnList = new ArrayList<>();
                for (int i = 0; i < splitedText.length; i++) {
                        columnList.add(splitedText[i]);
                }
                Location location = new Location();
    String dick = columnList.get(1);
                location.setLongitude(Float.parseFloat(columnList.get(1)));
                location.setLatitude(Float.parseFloat(columnList.get(2)));

                locations.add(location);
            }
            return locations;
        }


}
