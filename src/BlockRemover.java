//ID: 203486824 Roni Sedakah

/**
 * removes blocks from the game.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor.
     * @param game - the game.
     * @param removeBlocks - counter.
     */
    public BlockRemover(GameLevel game, Counter removeBlocks) {
        this.game = game;
        this.remainingBlocks = removeBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
        this.remainingBlocks.decrease(1);
    }
}
