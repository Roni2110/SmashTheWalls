//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * animation runner class.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private biuoop.Sleeper sleeper;

    /**
     * constructor.
     * @param gui - GUI.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.sleeper = new biuoop.Sleeper();
        this.framesPerSecond = 60;
    }

    /**
     * run the animation in the game.
     * @param animation - the animation given.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.gui.getDrawSurface();
            animation.doOneFrame(d);
            this.gui.show(d);

            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
        this.sleeper.sleepFor(500);
    }
}
