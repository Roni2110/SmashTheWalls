//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;

/**
 * a Sprite is a game object that can be drawn to the screen.
 * In our design, all of the game objects (Ball, Block, Paddle, ...) are Sprites
 * -- they will implement the Sprite interface
 */
public interface Sprite {

    /**
     * draw the sprite to the screen.
     * @param d - the surface we drawing it on.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}
