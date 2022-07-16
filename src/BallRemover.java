//ID: 203486824 Roni Sedakah

/**
 * removes ball from the game.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter ballsLeft;

    /**
     * constructor.
     * @param g - the game.
     * @param c - counter.
     */
    public BallRemover(GameLevel g, Counter c) {
        this.ballsLeft = c;
        this.game = g;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeBallFromGame(this.game);
        this.ballsLeft.decrease(1);
    }
}
