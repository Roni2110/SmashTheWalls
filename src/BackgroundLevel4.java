//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * draw background - level 4.
 */
public class BackgroundLevel4 implements Sprite {
    private Rectangle rectangle;

    /**
     * constructor.
     */
    public BackgroundLevel4() {
        this.rectangle = new Rectangle(new Point(0, 0), 800, 600, Color.BLUE);

    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(550, 36,  "Level Name: Final Four", 14);
        this.rectangle.drawOn(d);
        d.setColor(Color.red);
        int x = 400, y = 700;
        d.fillCircle(x, y, 400);
        d.setColor(Color.orange);
        d.fillCircle(x, y, 350);
        d.setColor(Color.yellow);
        d.fillCircle(x, y, 300);
        d.setColor(Color.green);
        d.fillCircle(x, y, 250);
        d.setColor(Color.blue);
        d.fillCircle(x, y, 200);
        d.setColor(Color.pink);
        d.fillCircle(x, y, 150);
        d.setColor(Color.white);
        d.fillCircle(120, 320, 40);
        d.fillCircle(80, 290, 40);
        d.fillCircle(60, 350, 40);
        d.fillCircle(20, 320, 40);
        d.fillCircle(720, 220, 40);
        d.fillCircle(680, 200, 40);
        d.fillCircle(660, 240, 40);
        d.fillCircle(620, 220, 40);
        d.setColor(Color.BLACK);
    }

    @Override
    public void timePassed() {

    }
}
