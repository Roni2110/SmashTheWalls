//ID: 203486824 Roni Sedakah
import java.util.Comparator;

/**
 * comparatorCollision class compare between two collisions info using the method compare.
 */
public class ComparatorCollision implements Comparator<CollisionInfo> {
    @Override
    public int compare(CollisionInfo o1, CollisionInfo o2) {
        Comparator<Point> comparator = new ComparatorPoint();
        return comparator.compare(o1.collisionPoint(), o2.collisionPoint());
    }
}
