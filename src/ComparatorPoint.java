//ID: 203486824 Roni Sedakah
import java.util.Comparator;

/**
 * comparatorPoint compare between two points using compare metho.
 */
public class ComparatorPoint implements Comparator<Point> {

    @Override
    public int compare(Point p1, Point p2) {
        return Double.compare(p1.getX(), p2.getX());
    }
}
