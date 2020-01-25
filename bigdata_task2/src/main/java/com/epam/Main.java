package com.epam;




import com.epam.dao.CrimeDAO;
import com.epam.dao.LocationDAO;
import com.epam.dao.StreetDAO;
import com.epam.entity.Crime;
import com.epam.entity.Location;
import com.epam.entity.Street;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

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


        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(sb.toString());

        Gson gson = new GsonBuilder().create();

        ArrayList<Crime> responseAsArrayList =
                gson.fromJson(json.toString(), new TypeToken<List<Crime>>() {
                }.getType());

        for(int i =0, x = 1;i<10;i++, x++)
        {
            Crime  crimeDto = responseAsArrayList.get(i);
            CrimeDAO crimeDAO = new CrimeDAO();
            LocationDAO locationDAO = new LocationDAO();
            StreetDAO streetDAO = new StreetDAO();
            Location location = crimeDto.getLocation();
            crimeDto.setLocationId(x);
            Street street = location.getStreet();
            boolean bool1 = streetDAO.insert(street);
            boolean bool2 = locationDAO.insert(location);
            boolean bool =  crimeDAO.insert(crimeDto);
            System.out.println(bool);
        }

    }
}
