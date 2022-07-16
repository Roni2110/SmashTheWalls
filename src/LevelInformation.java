//ID: 203486824 Roni Sedakah
import java.util.List;

/**
 * interface.
 */
public interface LevelInformation {

    /**
     * number of balls in the level.
     * @return - number of balls.
     */
    int numberOfBalls();

    /**
     * the initial velocity of each ball.
     * @return - a list of velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * the paddle speed.
     * @return - the paddle speeed.
     */
    int paddleSpeed();

    /**
     * the paddle width.
     * @return - the paddle width.
     */
    int paddleWidth();

    /**
     * the level name that displayed on the top of the screen.
     * @return - the level name.
     */
    String levelName();
    // Returns a sprite with the background of the level

    /**
     * the background of the level.
     * @return - sprite with the background.
     */
    Sprite getBackground();

    /**
     * the blocks in the level, each block contains its size,color and location.
     * @return - a list of blocks in the level.
     */
    List<Block> blocks();

    /**
     * nomber of blocks that should be removed from the game.
     * @return - number of blocks to be removed.
     */
    int numberOfBlocksToRemove();
}
