//ID: 203486824 Roni Sedakah
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * level 4 class.
 */
public class LevelFourGame implements LevelInformation {
    private int balls = 3;


    @Override
    public int numberOfBalls() {
        return balls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        Random random = new Random();
        List<Velocity> ballslist = new ArrayList<Velocity>();
        for (int i = 0; i < numberOfBalls(); i++) {
            ballslist.add(Velocity.fromAngleAndSpeed(random.nextInt(360), 4));
        }
        return ballslist;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return new BackgroundLevel4();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<Block>();
        double x = 10;
        double y = 100;
        int maxBlocks = 15;
        //the colours of the blocks
        Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.GREEN, Color.WHITE, Color.MAGENTA, Color.cyan};
        for (int i = 0; i < 7; i++) {
            x = 10;
            for (int j = 0; j < maxBlocks; j++) {
                Block block = new Block(new Point(x, y), 52, 30);
                block.setColor(colors[i]);
                blocks.add(block);
                x += 52;
            }
            y += 30;
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
