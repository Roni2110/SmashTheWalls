//ID: 203486824 Roni Sedakah
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 2 class.
 */
public class LevelTwoGame implements LevelInformation {
    private int balls  = 5;

    @Override
    public int numberOfBalls() {
        return balls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballsList = new ArrayList<>();
        for (int i = 0; i < this.balls / 2; i++) {
            ballsList.add(Velocity.fromAngleAndSpeed(310 * i + 10, 4));
        }
        for (int i = this.balls / 2; i < this.balls; i++) {
            ballsList.add(Velocity.fromAngleAndSpeed(100 - i * 10, 4));
        }
        return ballsList;
    }

    @Override
    public int paddleSpeed() {
        return 8;
    }

    @Override
    public int paddleWidth() {
        return 400;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new BackgroundLevel2();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<Block>();
        double x = 10;
        double y = 180;
        int maxBlocks = 15;
        for (int i = 0; i < maxBlocks; i++) {
            Block block = new Block(new Point(x, y), 52, 20);
            block.setColor(Color.BLUE);
            blocks.add(block);
            x += 52;
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
