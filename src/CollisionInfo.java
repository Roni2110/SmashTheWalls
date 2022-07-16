//ID: 203486824 Roni Sedakah

/**
 * collision info class "collect" all information of collidable objects.
 */
public class CollisionInfo {
    private Point pointCollision;
    private Collidable collidable;

    /**
     * constructor.
     * @param p - collision point.
     * @param c - the collidable object.
     */
    public CollisionInfo(Point p, Collidable c) {
        this.collidable = c;
        this.pointCollision = p;
    }


    /**
     * the point at which the collision occurs.
     * @return the point.
     */
    public Point collisionPoint() {
        return this.pointCollision;
    }


    /**
     * the collidable object involved in the collision.
     * @return the collidable.
     */
    public Collidable collisionObject() {
        return this.collidable;
    }
}
