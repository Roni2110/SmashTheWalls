//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;
import biuoop.Sleeper;

/**
 * count down class.
 */
public class CountdownAnimation implements Animation {
    private double seconds;
    private int startFrom;
    private SpriteCollection spriteCollection;
    private boolean stop;
    private boolean firstRound;


    /**
     * constructor.
     * @param numOfSeconds - how many sceonds to count.
     * @param countFrom - the number we start the counting from.
     * @param gameScreen - game screen.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.seconds = numOfSeconds;
        this.startFrom = countFrom;
        this.spriteCollection = gameScreen;
        this.stop = false;
        this.firstRound = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.spriteCollection.drawAllOn(d);
        IndicateCountDown countDown = new IndicateCountDown(this.startFrom);
        countDown.drawOn(d);
        if (this.startFrom == 0) {
            this.stop = true;
        }
        this.startFrom--;
        if (!this.firstRound) {
            Sleeper sleeper = new Sleeper();
            long timeInMill = (long) this.seconds * 500;
            sleeper.sleepFor(timeInMill);
        } else {
            this.firstRound = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
