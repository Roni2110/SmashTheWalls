//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;

/**
 * charge on the game scroe.
 */
public class MyScoreIndicator implements Sprite {
    private Rectangle rectangle;
    private Counter counter;

    /**
     * constructor.
     * @param width - width of the block.
     * @param c - the score counter.
     */
    public MyScoreIndicator(int width, Counter c) {
        this.rectangle = new Rectangle(new Point(0, 0), width, 20);
        this.counter = c;
    }


    @Override
    public void drawOn(DrawSurface d) {
        String str = "Score: " + this.counter.getValue();
        d.drawText(380, 36, str, 14);
    }

    @Override
    public void timePassed() {
    }

    /**
     * add score indicator to the game.
     * @param game - the game we're adding to.
     */
    public void addIndicatorToGame(GameLevel game) {
        game.addSprite(this);
    }

}
