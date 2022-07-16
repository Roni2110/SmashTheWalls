//ID: 203486824 Roni Sedakah

/**
 * charge on counting sprites. (blocks,balls).
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;


    /**
     * constructor.
     * @param countScore - the current score I have.
     */
    public ScoreTrackingListener(Counter countScore) {
        this.currentScore = countScore;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}

