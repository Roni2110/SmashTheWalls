//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * failed class.
 */
public class Failed implements Animation {
    private KeyboardSensor keyboardSensor;
    private boolean stopGame;
    private Counter counter;

    /**
     * constructor.
     * @param ks - keyboardsensor.
     * @param c - counter.
     */
    public Failed(KeyboardSensor ks, Counter c) {
        this.keyboardSensor = ks;
        this.counter = c;
        this.stopGame = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        String text = "Game Over! Your score is: " + Integer.toString(this.counter.getValue());
        d.drawText(10, 300, text, 32);
    }

    @Override
    public boolean shouldStop() {
        return this.stopGame;
    }
}
