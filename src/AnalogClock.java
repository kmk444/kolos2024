import java.io.FileWriter;
import java.io.IOException;

public class AnalogClock extends Clock {
    public AnalogClock(int hour, int minute, int second, City city) {
        super(hour, minute, second, city);
    }

    public void toSvg(String path){
        String result = "<svg width=\"200\" height=\"200\" viewBox=\"-100 -100 200 200\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "<circle cx=\"0\" cy=\"0\" r=\"90\" fill=\"none\" stroke=\"black\" stroke-width=\"2\" />\n" +
                "<g text-anchor=\"middle\">\n" +
                "  <text x=\"0\" y=\"-80\" dy=\"6\">12</text>\n" +
                "  <text x=\"80\" y=\"0\" dy=\"4\">3</text>\n" +
                "  <text x=\"0\" y=\"80\" dy=\"6\">6</text>\n" +
                "  <text x=\"-80\" y=\"0\" dy=\"4\">9</text>\n" +
                "</g>\n" +
                "</svg>";
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(result);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
