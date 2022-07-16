//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * key press stoppable animation class.
 */
public class KeyPressStoppableAnimation implements Animation {
    private String string;
    private KeyboardSensor keyboardSensor;
    private Animation animation;
    private boolean isAlreadyPressed;
    private boolean stopGame;

    /**
     * constructor.
     * @param ks - keyboardsensor.
     * @param key - string that tell to close the window.
     * @param ar - animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor ks, String key, Animation ar) {
        this.isAlreadyPressed = true;
        this.string = key;
        this.keyboardSensor = ks;
        this.animation = ar;
        this.stopGame = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.keyboardSensor.isPressed(this.string) && !this.isAlreadyPressed) {
            this.stopGame = true;
        }
        this.isAlreadyPressed = false;
        this.animation.doOneFrame(d);
    }

    @Override
    public boolean shouldStop() {
        return this.stopGame;
    }
}
