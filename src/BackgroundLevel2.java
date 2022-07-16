//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * draw background - level 2.
 */
public class BackgroundLevel2 implements Sprite {
    private Rectangle rectangle;

    /**
     * constructor.
     */
    public BackgroundLevel2() {
        this.rectangle = new Rectangle(new Point(0, 0), 800, 600, Color.PINK);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(550, 36,  "Level Name: Wide Easy", 14);
        this.rectangle.drawOn(d);
        d.setColor(Color.getHSBColor(142, 189, 174));
        d.fillCircle(300, 580, 60);
        d.setColor(Color.YELLOW);
        d.fillRectangle(600, 590, 30, 30);
        d.fillRectangle(600, 560, 30, 30);
        d.fillRectangle(600, 530, 30, 30);
        d.fillRectangle(598, 500, 30, 30);
        d.fillRectangle(597, 470, 30, 30);
        d.fillRectangle(594, 440, 30, 30);
        d.fillRectangle(591, 410, 30, 30);
        d.fillRectangle(587, 380, 30, 30);
        d.fillRectangle(584, 350, 30, 30);
        d.fillRectangle(578, 320, 30, 30);
        d.fillRectangle(572, 290, 30, 30);
        d.fillRectangle(565, 260, 30, 30);
        d.setColor(Color.GREEN);
        d.fillRectangle(565, 260, 30, 30);
        d.fillRectangle(540, 290, 30, 30);
        d.fillRectangle(520, 320, 30, 30);
        d.fillRectangle(500, 350, 30, 30);
        d.fillRectangle(470, 380, 30, 30);
        d.fillRectangle(450, 410, 30, 30);
        d.fillRectangle(565, 260, 30, 30);
        d.fillRectangle(537, 230, 30, 30);
        d.fillRectangle(504, 200, 30, 30);
        d.fillRectangle(478, 180, 30, 30);
        d.fillRectangle(442, 160, 30, 30);
        d.fillRectangle(530, 260, 30, 30);
        d.fillRectangle(495, 263, 30, 30);
        d.fillRectangle(460, 269, 30, 30);
        d.fillRectangle(425, 275, 30, 30);
        d.fillRectangle(395, 287, 30, 30);

        d.fillRectangle(565, 260, 30, 30);
        d.fillRectangle(565 + (565 - 540), 290, 30, 30);
        d.fillRectangle(565 + (565 - 520), 320, 30, 30);
        d.fillRectangle(565 + (565 - 500), 350, 30, 30);
        d.fillRectangle(565 + (565 - 470), 380, 30, 30);
        d.fillRectangle(565 + (565 - 450), 410, 30, 30);

        d.fillRectangle(565, 260, 30, 30);
        d.fillRectangle(565 + (565 - 537), 230, 30, 30);
        d.fillRectangle(565 + (565 - 504), 200, 30, 30);
        d.fillRectangle(565 + (565 - 478), 180, 30, 30);
        d.fillRectangle(565 + (565 - 442), 160, 30, 30);

        d.fillRectangle(595, 260, 30, 30);
        d.fillRectangle(630, 263, 30, 30);
        d.fillRectangle(665, 269, 30, 30);
        d.fillRectangle(700, 275, 30, 30);
        d.fillRectangle(735, 287, 30, 30);
        d.setColor(Color.BLACK);
    }

    @Override
    public void timePassed() {

    }
}
