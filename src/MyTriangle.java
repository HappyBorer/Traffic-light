import java.awt.*;
import java.awt.geom.Path2D;

public class MyTriangle {
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p1p2a;
    private Point p1p2b;
    private Point p2p3a;
    private Point p2p3b;
    private Point p3p1a;
    private Point p3p1b;

    public MyTriangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        p1p2a = Interpolate.interpolate(p1, p2, 0.2);
        p1p2b = Interpolate.interpolate(p1, p2, 0.8);
        p2p3a = Interpolate.interpolate(p2, p3, 0.2);
        p2p3b = Interpolate.interpolate(p2, p3, 0.8);
        p3p1a = Interpolate.interpolate(p3, p1, 0.2);
        p3p1b = Interpolate.interpolate(p3, p1, 0.8);
    }


    public void paintTriangle(Graphics2D gr){
        Path2D triangle = new Path2D.Double();
        triangle.moveTo(p1p2b.x, p1p2b.y);
        triangle.curveTo(p1p2b.x, p1p2b.y, p2.x, p2.y, p2p3a.x, p2p3a.y);
        triangle.lineTo(p2p3b.x, p2p3b.y);
        triangle.curveTo(p2p3b.x, p2p3b.y, p3.x, p3.y, p3p1a.x, p3p1a.y);
        triangle.lineTo(p3p1b.x, p3p1b.y);
        triangle.curveTo(p3p1b.x, p3p1b.y, p1.x, p1.y, p1p2a.x, p1p2a.y);
        triangle.closePath();
        gr.fill(triangle);
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    public Point getP1p2a() {
        return p1p2a;
    }

    public Point getP1p2b() {
        return p1p2b;
    }

    public Point getP2p3a() {
        return p2p3a;
    }

    public Point getP2p3b() {
        return p2p3b;
    }

    public Point getP3p1a() {
        return p3p1a;
    }

    public Point getP3p1b() {
        return p3p1b;
    }
}
