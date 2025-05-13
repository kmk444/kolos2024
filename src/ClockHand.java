import java.time.LocalTime;

public abstract class ClockHand {
    protected double angle;
    protected String stroke;
    protected double strokeWidth;
    protected double strokeLength;

    public abstract void setTime(LocalTime time);
    public abstract String toSvg();
}
