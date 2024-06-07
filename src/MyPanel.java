import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;


public class MyPanel extends JPanel {
    static Graphics2D gr;

    public void paint(Graphics g) {
        gr = (Graphics2D) g;
        RenderingHints rh = new RenderingHints( // для сглаживания линий фигур
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        gr.setRenderingHints(rh);
        gr.setColor(Color.DARK_GRAY);
        gr.fillRoundRect(200, 100, 60, 200, 20, 20);
        gr.fillRoundRect(215, 305, 30, 40, 20, 20);


        MyTriangle leftUp = new MyTriangle(
                new Point(155, 115),
                new Point(195, 115),
                new Point(195, 155));
        leftUp.paintTriangle(gr);

        MyTriangle leftMidl = new MyTriangle(
                new Point(155,175),
                new Point(195,175),
                new Point(195,215));
        leftMidl.paintTriangle(gr);

        MyTriangle leftDown = new MyTriangle(
                new Point(155,235),
                new Point(195,235),
                new Point(195,275));
        leftDown.paintTriangle(gr);

        MyTriangle rightUp = new MyTriangle(
                new Point(265, 115),
                new Point(305, 115),
                new Point(265, 155));
        rightUp.paintTriangle(gr);

        MyTriangle rightMidl = new MyTriangle(
                new Point(265,175),
                new Point(305,175),
                new Point(265,215));
        rightMidl.paintTriangle(gr);

        MyTriangle rightDown = new MyTriangle(
                new Point(265,235),
                new Point(305,235),
                new Point(265,275));
        rightDown.paintTriangle(gr);

        Point p1 = new Point(210,95);
        Point p2 = new Point(230, 75);
        Point p3 = new Point(250, 95);

        Point p1p2a = Interpolate.interpolate(p1, p2, 0.2);
        Point p1p2b = Interpolate.interpolate(p1, p2, 0.6);
        Point p2p3a = Interpolate.interpolate(p2,p3, 0.4);
        Point p2p3b = Interpolate.interpolate(p2,p3, 0.8);
        Point p3p1a = Interpolate.interpolate(p3,p1, 0.2);
        Point p3p1b = Interpolate.interpolate(p3,p1, 0.8);

        Path2D p2d = new Path2D.Double();
        p2d.moveTo(p3p1b.x, p3p1b.y);
        p2d.curveTo(p3p1b.x, p3p1b.y,p1.x,p1.y, p1p2a.x,p1p2a.y);
        p2d.curveTo(p1p2b.x,p1p2b.y, p2p3a.x, p2p3a.y, p2p3b.x, p2p3b.y);
        p2d.curveTo(p2p3b.x, p2p3b.y, p3.x, p3.y, p3p1a.x, p3p1a.y);
        p2d.closePath();
        gr.fill(p2d);

        gr.setColor(Color.RED);
        gr.fillOval(205, 115, 50, 50);
        gr.setColor(Color.YELLOW);
        gr.fillOval(205, 177, 50, 50);
        gr.setColor(Color.GREEN);
        gr.fillOval(205, 239, 50, 50);


        gr.setColor(Color.WHITE);

        Trump trump1 = new Trump(
                new Point(203, 135),
                new Point(203, 95),
                new Point(257, 95),
                new Point(257, 135)
        );
        trump1.paintTrump(gr);
        Trump trump2 = new Trump(
                new Point(203, 197),
                new Point(203, 157),
                new Point(257, 157),
                new Point(257, 197)
        );
        trump2.paintTrump(gr);
        Trump trump3 = new Trump(
                new Point(203, 259),
                new Point(203, 219),
                new Point(257, 219),
                new Point(257, 259)
        );
        trump3.paintTrump(gr);
    }

}
