//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * counter indicator class.
 */
public class IndicateCountDown implements Sprite {
    private int countDown;

    /**
     * constructor.
     * @param number - number we represent.
     */
    public IndicateCountDown(int number) {
        this.countDown = number;
    }

    @Override
    public void drawOn(DrawSurface d) {
        String write = Integer.toString(this.countDown);
        d.setColor(Color.RED);
        d.drawText(400, 400, write, 40);
    }

    @Override
    public void timePassed() {

    }
}
