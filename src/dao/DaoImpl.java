package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DaoImpl {
    public String [] getData(String firstName, String lastName) throws IOException{
        InputStream is = getClass().getResourceAsStream("/../../data.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        String fileString;
        boolean isFitting = false;
        fileString = in.readLine();
        while (fileString != null && !fileString.contains(firstName + ";" + lastName)) {
            fileString = in.readLine();
        }
        if (fileString == null){
            return new String[] {firstName, lastName, "Not found", "Not found"};
        }
        String[] result = fileString.split(";");
        return result;
    }
}
