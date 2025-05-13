import java.time.LocalTime;
import java.util.Locale;

public class HourHand extends ClockHand {
    private double hour;

    public HourHand(String stroke, double strokeWidth, double strokeLength){
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
        this.strokeLength = -strokeLength;
    }

    @Override
    public void setTime(LocalTime time) {
        this.hour = time.getHour();
        this.angle = hour*30 + (time.getMinute() * 6 + time.getSecond()*6)*0.1;
    }

    @Override
    public String toSvg() {
        return String.format(Locale.ENGLISH, "<line x1=\"0\" y1=\"0\" x2=\"0\" y2=\"%f\" stroke=\"%s\" stroke-width=\"%f\" transform=\"rotate(%f)\" />",
                this.strokeLength, this.stroke, this.strokeWidth, this.angle);
    }
}
