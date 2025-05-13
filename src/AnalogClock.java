import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AnalogClock extends Clock {
    private final List<ClockHand> hands = new ArrayList<>();
    public AnalogClock(int hour, int minute, int second, City city, HourHand hourHand, MinuteHand minuteHand, SecondHand secondHand) {
        super(hour, minute, second, city);
        hands.add(hourHand);
        hands.add(minuteHand);
        hands.add(secondHand);
    }



    public void toSvg(String path){
        LocalTime currentHandsTime = LocalTime.of(getHour(),getMinute(),getSecond());
        String result = "<svg width=\"200\" height=\"200\" viewBox=\"-100 -100 200 200\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "<circle cx=\"0\" cy=\"0\" r=\"90\" fill=\"white\" stroke=\"black\" stroke-width=\"2\" />\n" +
                "<g text-anchor=\"middle\">\n" +
                "  <text x=\"0\" y=\"-80\" dy=\"6\">12</text>\n" +
                "  <text x=\"80\" y=\"0\" dy=\"4\">3</text>\n" +
                "  <text x=\"0\" y=\"80\" dy=\"6\">6</text>\n" +
                "  <text x=\"-80\" y=\"0\" dy=\"4\">9</text>\n" +
                "</g>\n";
        for( ClockHand hand : hands ){
            hand.setTime(currentHandsTime);
            result += hand.toSvg() + "\n";
        }

        result += "\n</svg>";
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(result);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
