//ID: 203486824 Roni Sedakah
import java.util.ArrayList;
import java.util.Comparator;

/**
 * The GameEnvironment class will be a collection of objects that a ball can collide with.
 */
public class GameEnvironment {
    private ArrayList<Collidable> list;

    /**
     * constructor.
     */
    public GameEnvironment() {
        this.list = new ArrayList<Collidable>();
    }


    /**
     * add the given collidable to the environment.
     * @param c the collidable given.
     */
    public void addCollidable(Collidable c) {
        this.list.add(c);
    }

    /**
     * an object moving from line.start() to line.end().
     * @param trajectory - the line the object moving.
     * @return if not collide with any of the collidables return null.
     * else, return the information about the collision that is going to occur.
     */
    public CollisionInfo  getClosestCollision(Line trajectory) {
        ArrayList<CollisionInfo> arrayList = new ArrayList<CollisionInfo>();
        for (int i = 0; i < this.list.size(); i++) {
            Rectangle colided = (Rectangle) this.list.get(i).getCollisionRectangle();
            Point point = trajectory.closestIntersectionToStartOfLine(colided);
            if (point != null) {
                arrayList.add(new CollisionInfo(point, this.list.get(i)));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Comparator<CollisionInfo> comparator = new ComparatorCollision();
        arrayList.sort(comparator);
        int size = arrayList.size();
        if (trajectory.start().getX() > trajectory.end().getY()) {
            return (CollisionInfo) arrayList.get(size - 1);
        } else {
            return (CollisionInfo) arrayList.get(0);
        }
    }

    /**
     * get the list of the collidables.
     * @return list of collidables.
     */
    public ArrayList<Collidable> getList() {
        return this.list;
    }

    /**
     * remove collidable from game environment.
     * @param c - the collidable being removed.
     */
    public void removeFromEnvironment(Collidable c) {
        this.list.remove(c);
    }
}
