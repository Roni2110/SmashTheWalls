//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * draw background - level 1.
 */
public class BackgroundLevel1 implements Sprite {
    private Rectangle rectangle;
    private Color color;

    /**
     * constructor.
     */
    public BackgroundLevel1() {
        this.rectangle = new Rectangle(new Point(10, 40), 780, 580);
        this.color = Color.BLACK;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(550, 36,  "Level Name: Direct Hit", 14);
        this.rectangle.drawOn(d);
        d.setColor(Color.BLUE);
        d.drawLine(520, 210, 420, 210);
        d.drawLine(280, 210, 380, 210);
        d.drawLine(400, 90, 400, 190);
        d.drawLine(400, 330, 400, 230);
        d.drawCircle(400, 210, 100);
        d.drawCircle(400, 210, 75);
        d.drawCircle(400, 210, 50);
        d.setColor(Color.BLACK);
    }

    @Override
    public void timePassed() {

    }
}
