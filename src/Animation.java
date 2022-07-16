//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;

/**
 * interface.
 */
public interface Animation {
    /**
     * add one frame to the game.
     * @param d - surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * stopping condition.
     * @return - True if should stop, False otherwise.
     */
    boolean shouldStop();
}
