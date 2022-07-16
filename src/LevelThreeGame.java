//ID: 203486824 Roni Sedakah
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * level 3 class.
 */
public class LevelThreeGame implements LevelInformation {
    private int balls = 1;

    @Override
    public int numberOfBalls() {
        return balls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> balls = new ArrayList<>();
        balls.add(new Velocity(4, 4));
        return balls;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 200;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return new BackgroundLevel3();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<Block>();
        double x = 290;
        double y = 120;
        int maxBlocks = 10;
        //the colours of the blocks
        Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.CYAN, Color.WHITE};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < maxBlocks; j++) {
                Block block = new Block(new Point(x, y), 50, 30);
                block.setColor(colors[i]);
                blocks.add(block);
                x += 50;
            }
            maxBlocks = maxBlocks - 1;
            x = 290 + (50 * (i + 1));
            y += 30;
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
