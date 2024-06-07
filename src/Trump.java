import java.awt.*;
import java.awt.geom.Path2D;

public class Trump {
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    private Point p1p2;
    private Point p3p4;
    public Trump(Point p1, Point p2, Point p3, Point p4){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        p1p2 = Interpolate.interpolate(p1, p2, 0.8);
        p3p4 = Interpolate.interpolate(p4, p3,0.8);
    }

    public void paintTrump(Graphics2D gr){
        Path2D moon = new Path2D.Double();
        moon.moveTo(p1.x, p1.y);
        moon.curveTo(p2.x, p2.y, p3.x, p3.y, p4.x, p4.y);
        moon.curveTo(p3p4.x, p3p4.y, p1p2.x, p1p2.y, p1.x,p1.y);
        gr.fill(moon);
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

    public void setP4(Point p4) {
        this.p4 = p4;
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

    public Point getP4() {
        return p4;
    }

    public Point getP1p2() {
        return p1p2;
    }

    public Point getP3p4() {
        return p3p4;
    }
}
