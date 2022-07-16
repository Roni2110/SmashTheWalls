//ID: 203486824 Roni Sedakah
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 1 class.
 */
public class LeveOneGame implements LevelInformation {
    private int balls = 1;

    @Override
    public int numberOfBalls() {
        return balls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> balls = new ArrayList<>();
        balls.add(new Velocity(0, 3));
        return balls;
    }

    @Override
    public int paddleSpeed() {
        return 4;
    }

    @Override
    public int paddleWidth() {
        return 200;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new BackgroundLevel1();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Rectangle rectangle = new Rectangle(new Point(370, 320), 60, 20);
        blocks.add(new Block(rectangle, Color.RED));
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
