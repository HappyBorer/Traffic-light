import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.QuadCurve2D;


public class MyPanel extends JPanel {
    public void paint(Graphics g){
        Graphics2D gr = (Graphics2D) g;
        gr.setColor(Color.DARK_GRAY);
        gr.fillRoundRect(200, 100, 90, 300, 20, 20);
        gr.fillRoundRect(225, 405, 40, 50, 20, 20);
//        int[] x = {150, 180, 180};
//        int[] y = {110, 110, 150};
        // gr.fillPolygon(x, y, 3);




        Point p1 = new Point(155,115);
        Point p2 = new Point(195,115);
        Point p3 = new Point(195,155);

        gr.fill(createdTriangle(p1, p2, p3, gr));
        p1 = new Point(155,175);
        p2 = new Point(195,175);
        p3 = new Point(195,215);
        gr.fill(createdTriangle(p1, p2, p3, gr));
        p1 = new Point(155,235);
        p2 = new Point(195,235);
        p3 = new Point(195,275);
        gr.fill(createdTriangle(p1, p2, p3, gr));


        p1 = new Point(305,115);
        p2 = new Point(305,155);
        p3 = new Point(345,115);
        gr.fill(createdTriangle(p1, p2, p3, gr));
        p1 = new Point(305,175);
        p2 = new Point(345,175);
        p3 = new Point(345,215);
        gr.fill(createdTriangle(p1, p2, p3, gr));
        p1 = new Point(305,235);
        p2 = new Point(345,235);
        p3 = new Point(345,275);
        gr.fill(createdTriangle(p1, p2, p3, gr));
    }
    public Point interpolate(Point p1, Point p2, double t){
        return new Point((int)Math.round(p1.x * (1-t) + p2.x*t),
                (int)Math.round(p1.y * (1-t) + p2.y*t));
    }

    protected  Path2D MyTriangle(Point p1, Point p2, Point p3, Graphics2D gr){
        Path2D triangle = new Path2D.Double();
        triangle.moveTo(p1.x, p1.y);
        return null;
    }
    protected Path2D createdTriangle(Point p1, Point p2, Point p3, Graphics2D gr){
        Point p1p2a = interpolate(p1, p2, 0.2);
        Point p1p2b = interpolate(p1, p2, 0.8);

        Point p2p3a = interpolate(p2, p3, 0.2);
        Point p2p3b = interpolate(p2, p3, 0.8);

        Point p3p1a = interpolate(p3, p1, 0.2);
        Point p3p1b = interpolate(p3, p1, 0.8);


        gr.drawLine(p1p2a.x, p1p2a.y, p1p2b.x, p1p2b.y);
        gr.drawLine(p2p3a.x, p2p3a.y, p2p3b.x, p2p3b.y);
        gr.drawLine(p3p1a.x, p3p1a.y, p3p1b.x, p3p1b.y);
        QuadCurve2D c1 = new QuadCurve2D.Double(p1p2b.x, p1p2b.y, p2.x, p2.y, p2p3a.x, p2p3a.y);
        QuadCurve2D c2 = new QuadCurve2D.Double(p2p3b.x, p2p3b.y, p3.x, p3.y, p3p1a.x, p3p1a.y);
        QuadCurve2D c3 = new QuadCurve2D.Double(p3p1b.x, p3p1b.y, p1.x, p1.y, p1p2a.x, p1p2a.y);
        Path2D path = new Path2D.Double();
        AffineTransform at = new AffineTransform();
        path.moveTo(p1p2a.x, p1p2a.y);
        path.lineTo(p1p2b.x, p1p2b.y);
        path.append(c1.getPathIterator(at), true);
        path.lineTo(p2p3b.x, p2p3b.y);
        path.append(c2.getPathIterator(at), true);
        path.lineTo(p3p1b.x, p3p1b.y);
        path.append(c3.getPathIterator(at), true);
        path.closePath();
        return path;
    }
}
