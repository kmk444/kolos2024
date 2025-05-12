import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Clock {
    private int hour;
    private int minute;
    private int second;
    private City city;

    public Clock(int hour, int minute, int second, City city) {

        this.city = city;
        setTime(hour,minute,second);
    }

    public String currentCity() { //tymczasowe
        return city.getCapital();
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public String toString(){
        return String.format("%02d:%02d:%02d",hour,minute,second);
    }

    public LocalTime toLocalTime(){
        return LocalTime.of(this.getHour(), this.getMinute(), this.getSecond());
    }


    public void setTime(int hour, int minute, int second) throws IllegalArgumentException {
        if (hour>24 || hour<0) throw new IllegalArgumentException("Error: an hour should be a value between 0 and 24.");
        else if (minute>60 || minute<0) throw new IllegalArgumentException("Error: a minute should be a value between 0 and 60.");
        else if (second>60 || second<0) throw new IllegalArgumentException("Error: a second should be a value between 0 and 60.");
        this.hour = Math.abs(hour + city.getSummerTimezone());
        this.minute = minute;
        this.second = second;
    }

    public void setCurrentTime() {
        LocalTime local = LocalTime.now();
        int localHour = local.getHour();
        int localMinute = local.getMinute();
        int localSecond = local.getSecond();
        setTime(localHour,localMinute,localSecond);
    }

    public void setCity(City newCity){
        int timeDifference = newCity.getSummerTimezone() - this.city.getSummerTimezone();
        int newHour = (this.hour + timeDifference + 24) % 24;

        this.city = newCity;
        setTime(newHour, this.minute, this.second);
    }
}
