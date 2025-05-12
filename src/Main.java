import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, City> cities =  City.parseFile("strefy.csv");
        City oslo = cities.get("Oslo");
        City vancouver = cities.get("Vancouver");


        DigitalClock clock = new DigitalClock(0,20,22, oslo, DigitalClock.Type.HOUR_24);
        System.out.println(clock);
        System.out.println(clock.currentCity() + " " + oslo.getSummerTimezone());


        clock.setCity(vancouver);
        System.out.println(clock);
        System.out.println(clock.currentCity() + " " + vancouver.getSummerTimezone());


    }
}