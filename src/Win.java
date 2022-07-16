//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * winnning class.
 */
public class Win implements Animation {
    private KeyboardSensor keyboardSensor;
    private boolean stopGame;
    private Counter counter;

    /**
     * constructor.
     * @param ks - keyboardsensor.
     * @param c - counter.
     */
    public Win(KeyboardSensor ks, Counter c) {
        this.keyboardSensor = ks;
        this.counter = c;
        this.stopGame = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        String text = "Winner! Your score is: " + this.counter.getValue();
        d.drawText(10, 300, text, 32);
    }

    @Override
    public boolean shouldStop() {
        return this.stopGame;
    }
}
