import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class City {
    private String capital;
    private int summerTimezone;
    private double longitude;
    private double latitude;


    public String getCapital() {
        return capital;
    }

    public int getSummerTimezone() {
        return summerTimezone;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public City(String capital, int summerTimezone, double longitude, double latitude) {
        this.capital = capital;
        this.summerTimezone = summerTimezone;
        this.longitude = longitude;
        this.latitude = latitude;
    }

//    @Override
//    public String toString() {
//        return "City{" +
//                "capital='" + capital + '\'' +
//                ", summerTimezone=" + summerTimezone +
//                ", longitude=" + longitude +
//                ", latitude=" + latitude +
//                '}';
//    }

    public String toString(){
        return String.format("\n>-->%s:\n summer timezone = %d\nlongitude = %f\nlatitude =  %f\n",
                capital, summerTimezone, longitude, latitude);
    }

    private static City parseLine(String line){
        String[] tokens = line.split(",");
        String capital = tokens[0];
        int summmerTimezone = Integer.parseInt(tokens[1]);
        String[] longitudeTokens = tokens[3].trim().split(" ");
        String[] latitudeTokens = tokens[2].trim().split(" ");
        double longitude = Double.parseDouble(longitudeTokens[0]);
        if (longitudeTokens[1].equals("W")) longitude = -longitude;
        double latitude = Double.parseDouble(latitudeTokens[0]);
        if (latitudeTokens[1].equals("S")) latitude = -latitude;
        return new City(capital, summmerTimezone, longitude, latitude);
    }

    public static HashMap<String, City> parseFile (String path){
        try {
            HashMap<String, City> cities = new HashMap<>();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            reader.readLine();
            String line;
            while((line = reader.readLine())!=null)
            {
                String[] tokens = line.split(",");
                String name = tokens[0];
                cities.put(name, parseLine(line));
            }
            return cities;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
