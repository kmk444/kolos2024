import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, City> cities =  City.parseFile("strefy.csv");
        City oslo = cities.get("Oslo");
//        City vancouver = cities.get("Vancouver");
//
//
//        DigitalClock clock = new DigitalClock(0,20,22, oslo, DigitalClock.Type.HOUR_24);
//        System.out.println(clock);
//        System.out.println(clock.currentCity() + " " + oslo.getSummerTimezone());
//
//
//        clock.setCity(vancouver);
//        System.out.println(clock);
//        System.out.println(clock.currentCity() + " " + vancouver.getSummerTimezone());



        City lublin = cities.get("Lublin");
//        DigitalClock lublinClock = new DigitalClock(10,0,0, lublin, DigitalClock.Type.HOUR_24);
//        System.out.println(lublinClock.toLocalTime());
//        System.out.println(lublin.localMeanTime(lublinClock.toLocalTime()));

        AnalogClock clock = new AnalogClock(12,37,10, lublin);
        clock.toSvg("0.svg");



        LocalTime time = LocalTime.of(21,40,0);

        SecondHand sh = new SecondHand("lightsalmon",2,70);
        sh.setTime(time);
        System.out.println(sh.toSvg());

        MinuteHand mh = new MinuteHand("indigo",4,50);
        mh.setTime(time);
        System.out.println(mh.toSvg());

        HourHand hh = new HourHand("black",6,30);
        hh.setTime(time);
        System.out.println(hh.toSvg());


    }
}