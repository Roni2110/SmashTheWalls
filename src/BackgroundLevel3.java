//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * draw background - level 3.
 */
public class BackgroundLevel3 implements Sprite {
    private Rectangle rectangle;

    /**
     * constructor.
     */
    public BackgroundLevel3() {
        this.rectangle = new Rectangle(new Point(0, 0), 800, 600, Color.BLUE);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(550, 36,  "Level Name: Green 3", 14);
        this.rectangle.drawOn(d);
        d.setColor(Color.black);
        d.fillRectangle(450, 360, 50, 10);
        d.fillRectangle(680, 190, 50, 10);
        d.fillRectangle(350, 520, 50, 10);
        d.fillRectangle(245, 390, 50, 10);
        d.fillRectangle(89, 120, 50, 10);
        d.fillRectangle(150, 360, 50, 10);
        d.fillRectangle(30, 200, 50, 10);
        d.fillRectangle(700, 420, 50, 10);
        d.fillRectangle(295, 240, 50, 10);
        d.fillRectangle(739, 120, 50, 10);


        d.fillCircle(450, 370, 30);
        d.fillCircle(680, 200, 30);
        d.fillCircle(350, 530, 30);
        d.fillCircle(245, 400, 30);
        d.fillCircle(89, 130, 30);
        d.fillCircle(150, 370, 30);
        d.fillCircle(80, 200, 30);
        d.fillCircle(750, 420, 30);
        d.fillCircle(345, 240, 30);
        d.fillCircle(789, 130, 30);

        d.setColor(Color.white);
        d.fillCircle(450, 370, 20);
        d.fillCircle(680, 200, 20);
        d.fillCircle(350, 530, 20);
        d.fillCircle(245, 400, 20);
        d.fillCircle(89, 130, 20);
        d.fillCircle(150, 370, 20);
        d.fillCircle(80,  200, 20);
        d.fillCircle(750, 420, 20);
        d.fillCircle(345, 240, 20);
        d.fillCircle(789, 130, 20);
        d.setColor(Color.orange);
        d.fillCircle(450, 370, 10);
        d.fillCircle(680, 200, 10);
        d.fillCircle(350, 530, 10);
        d.fillCircle(245, 400, 10);
        d.fillCircle(89, 130, 10);
        d.fillCircle(150, 370, 10);
        d.fillCircle(80, 200, 10);
        d.fillCircle(750, 420, 10);
        d.fillCircle(345, 240, 10);
        d.fillCircle(789, 130, 10);
        d.setColor(Color.BLACK);
    }

    @Override
    public void timePassed() {

    }
}
