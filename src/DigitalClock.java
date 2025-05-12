public class DigitalClock extends Clock {
    public enum Type {
        HOUR_12,
        HOUR_24
    }
    private Type type;

    public DigitalClock(int hour, int minute, int second, Type type) {
        setTime(hour, minute, second);
        this.type = type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        if (type.equals(Type.HOUR_24)) return super.toString();
        else {
            String note = "AM";
            int hour = getHour();
            if (hour>12 || hour==0) {
                hour = Math.abs(getHour() - 12);
                if((getHour() - 12) > 0) note = "PM";
            }
            return String.format("%d:%02d:%02d %s",hour,getMinute(),getSecond(), note);
        }
    }
}
