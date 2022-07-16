//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.List;

/**
 * the game we going to play.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private biuoop.Sleeper sleeper;
    private Counter remainingBlocks;
    private Counter ballsLeft;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;

    private LevelInformation levelInformation;


    /**
     * constructor.
     * @param li - level information.
     * @param ks - keyboard.
     * @param ar - animation.
     * @param c - counter.
     * @param g - GUI.
     */
    public GameLevel(LevelInformation  li, KeyboardSensor ks, AnimationRunner ar, Counter c, GUI g) {
        this.levelInformation = li;
        this.gui = g;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.remainingBlocks = new Counter(this.levelInformation.numberOfBlocksToRemove());
        this.ballsLeft = new Counter(this.levelInformation.numberOfBalls());
        this.score = c;
        this.running = false;
        this.runner = ar;
        this.keyboard = ks;
    }

    /**
     * add a collidable to the game.
     * @param c - the collidable being added.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * add the sprite to the sprite collection.
     * @param s - the sprite being added.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    // Initialize a new game: create the Blocks and Ball (and Paddle)
    // and add them to the game.

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        //the keyboard sensor
        biuoop.KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        if (this.levelInformation.getBackground() != null) {
            this.addSprite(this.levelInformation.getBackground());
        }
        //the boarders of the game.
        this.generateBoarders();
        //the paddle of the game
        Paddle paddle = new Paddle(this.keyboard, this.levelInformation.paddleWidth(),
                this.levelInformation.paddleSpeed());
        paddle.addToGame(this);

        //create the balls.
        for (int i = 0; i < this.ballsLeft.getValue(); i++) {
            generateBalls(new Point(400, 550), this.levelInformation.initialBallVelocities().get(i));
        }
        //the blocks in the game
        this.generateBlocks(this.levelInformation.blocks());
    }

    /**
     * run the game - start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;
        this.runner.run(this);
    }

    /**
     * generate the boarders game.
     */
    public void generateBoarders() {
        BallRemover ballRemover = new BallRemover(this, this.ballsLeft);
        MyScoreIndicator myScoreIndicator = new MyScoreIndicator(800, this.score);
        myScoreIndicator.addIndicatorToGame(this);
        Block upperBlock = new Block(new Point(0, 20), 800, 5);
        upperBlock.addToGame(this);
        Block leftBlock = new Block(new Point(795, 20), 5, 600);
        leftBlock.addToGame(this);
        Block deathRegion = new Block(new Point(0, 600), 800, 5);
        deathRegion.addToGame(this);
        deathRegion.addHitListener(ballRemover);
        Block rightBlock = new Block(new Point(0, 20), 5, 600);
        rightBlock.addToGame(this);
    }

    /**
     * generate a ball to the game.
     * @param center - the center of the ball.
     * @param velocity - the velocity of the ball.
     */
    public void generateBalls(Point center, Velocity velocity) {
        Ball ball = new Ball(center, 10, Color.GRAY, this.environment);
        ball.setVelocity(velocity);
        ball.addToGame(this);
    }

    /**
     * generate the blocks.
     * @param blocks - list of blocks.
     */
    public void generateBlocks(List<Block> blocks) {
        ScoreTrackingListener trackingListener = new ScoreTrackingListener(this.score);
        BlockRemover blockRemover = new BlockRemover(this, this.remainingBlocks);

        for (int i = 0; i < this.remainingBlocks.getValue(); i++) {
            Block block = this.levelInformation.blocks().get(i);
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(trackingListener);
        }
    }

    /**
     * remove a collidable from the game.
     * @param c - the collidable being removed.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeFromEnvironment(c);
    }

    /**
     * remove a sprite from the game.
     * @param s - the sprite being removed.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeFromSpriteList(s);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.remainingBlocks.getValue() == 0) {
            this.score.increase(100);
            this.sprites.drawAllOn(d);
            this.running = false;
        } else {
            this.sprites.drawAllOn(d);
            if (this.ballsLeft.getValue() == 0) {
                this.running = false;
            } else {
                this.sprites.notifyAllTimePassed();
            }
        }
        if (this.keyboard.isPressed("p")) {
           Animation pauseGame = new KeyPressStoppableAnimation(this.keyboard, this.keyboard.SPACE_KEY,
                   new PauseScreen(this.keyboard));
           this.runner.run(pauseGame);
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * check if running is true or false.
     * @return - true / false.
     */
    public boolean isRunning() {
        return this.running;
    }

    /**
     * setter.
     */
    public void setRunning() {
        this.running = true;
    }

    /**
     * getter.
     * @return - number of balls left.
     */
    public Counter getBallsLeft() {
        return ballsLeft;
    }


}
