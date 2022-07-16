//ID: 203486824 Roni Sedakah

/**
 * interface.
 */
public interface HitListener {
    /**
     * called whenever the beingHit object is hit.
     * @param beingHit - the object being hit.
     * @param hitter - the ball the hitting the object.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
