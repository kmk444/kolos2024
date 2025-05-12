import java.time.LocalDateTime;

public abstract class Clock {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public String toString(){
        return String.format("%02d:%02d:%02d",hour,minute,second);
    }

    public void setTime(int hour, int minute, int second) throws IllegalArgumentException {
        if (hour>24 || hour<0) throw new IllegalArgumentException("Error: an hour should be a value between 0 and 24.");
        else if (minute>60 || minute<0) throw new IllegalArgumentException("Error: a minute should be a value between 0 and 60.");
        else if (second>60 || second<0) throw new IllegalArgumentException("Error: a second should be a value between 0 and 60.");
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setCurrentTime() {
        LocalDateTime local = LocalDateTime.now();
        int localHour = local.getHour();
        int localMinute = local.getMinute();
        int localSecond = local.getSecond();
        setTime(localHour,localMinute,localSecond);
    }

}
