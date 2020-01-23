package com.epam.dao;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class f {
    public static void main(String[] args) throws Exception {
        URLConnection connection = new URL("https://data.police.uk/api/crime-categories?date=2011-08").openConnection();

        InputStream is = connection.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        char[] buffer = new char[256];
        int rc;

        StringBuilder sb = new StringBuilder();

        while ((rc = reader.read(buffer)) != -1)
            sb.append(buffer, 0, rc);

        reader.close();

        System.out.println(sb);
    }

}
