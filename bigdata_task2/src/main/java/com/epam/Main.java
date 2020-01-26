package com.epam;


import com.epam.dao.*;
import com.epam.entity.Crime;
import com.epam.entity.Location;
import com.epam.entity.OutcomeStatus;
import com.epam.entity.Street;
import com.epam.service.CSVParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static  final String FILE_PATH = "./src/main/resources/LondonStations.csv";
    public static void main(String[] args) throws Exception {


        URLConnection connection = new URL("https://data.police.uk/api/crimes-street/all-crime?lat=52.629729&lng=-1.131592").openConnection();

        InputStream is = connection.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        char[] buffer = new char[256];
        int rc;

        StringBuilder sb = new StringBuilder();

        while ((rc = reader.read(buffer)) != -1) {
            sb.append(buffer, 0, rc);
        }


        reader.close();

        System.out.println(sb);

     
        List<Location> products =  new CSVParser().parseProductCsv(FILE_PATH);
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(sb.toString());

        Gson gson = new GsonBuilder().create();

        ArrayList<Crime> responseAsArrayList =
                gson.fromJson(json.toString(), new TypeToken<List<Crime>>() {
                }.getType());

        try {
            for (int i = 0, x = 1; i < responseAsArrayList.size(); i++, x++) {
                Crime crimeDto = responseAsArrayList.get(i);
                CrimeDAO crimeDAO = new CrimeDAO();
                LocationDAO locationDAO = new LocationDAO();
                StreetDAO streetDAO = new StreetDAO();
                OutcomeStatusDAO outcomeStatusDAO = new OutcomeStatusDAO();
                Location location = crimeDto.getLocation();
                crimeDto.setLocationId(x);
                crimeDto.setOutcomeStatusId(x);
                Street street = location.getStreet();
                OutcomeStatus outcomeStatus = crimeDto.getOutcomeStatus();
                boolean bool3 = outcomeStatusDAO.insert(outcomeStatus);
                boolean bool1 = streetDAO.insert(street);
                boolean bool2 = locationDAO.insert(location);
                boolean bool = crimeDAO.insert(crimeDto);
                System.out.println(bool);
            }
        } catch (DAOException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
