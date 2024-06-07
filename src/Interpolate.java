import java.awt.*;

public class Interpolate {
    public static Point interpolate(Point p1, Point p2, double t){
        return new Point((int)Math.round(p1.x * (1-t) + p2.x*t),
                (int)Math.round(p1.y * (1-t) + p2.y*t));
    }
}
