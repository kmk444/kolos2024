import java.time.LocalTime;
import java.util.Locale;

public class SecondHand extends ClockHand {
    private double second;

    public SecondHand(String stroke, double strokeWidth, double strokeLength){
        this.stroke = stroke;
        this.strokeWidth = strokeWidth;
        this.strokeLength = -strokeLength;
    }

    @Override
    public void setTime(LocalTime time) {
        this.second = time.getSecond();
        System.out.println(second);
        this.angle = second * 6;
    }

    @Override
    public String toSvg() {
        return String.format(Locale.ENGLISH, "<line x1=\"0\" y1=\"0\" x2=\"0\" y2=\"%f\" stroke=\"%s\" stroke-width=\"%f\" transform=\"rotate(%f)\" />",
                this.strokeLength, this.stroke, this.strokeWidth, this.angle);
    }
}
