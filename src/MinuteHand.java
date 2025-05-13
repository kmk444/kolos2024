import java.time.LocalTime;
import java.util.Locale;

public class MinuteHand extends ClockHand{
    private double minute;

    public MinuteHand(String stroke, double strokeWidth, double strokeLength){
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
        this.strokeLength = -strokeLength;
    }

    @Override
    public void setTime(LocalTime time) {
        this.minute = time.getMinute();
        this.angle = minute * 6 + time.getSecond()*0.1;
    }

    @Override
    public String toSvg() {
        return String.format(Locale.ENGLISH, "<line x1=\"0\" y1=\"0\" x2=\"0\" y2=\"%f\" stroke=\"%s\" stroke-width=\"%f\" transform=\"rotate(%f)\" />",
                this.strokeLength, this.stroke, this.strokeWidth, this.angle);
    }
}
