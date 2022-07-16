//ID: 203486824 Roni Sedakah

/**
 * interface.
 */
public interface HitNotifier {
    /**
     * add hl as a listener to hit events.
     * @param hl - hit listener object.
     */
    void addHitListener(HitListener hl);

    /**
     * remove hl from the list of listeners to hit events.
     * @param hl - hit listener object.
     */
    void removeHitListener(HitListener hl);
}
