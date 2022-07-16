//ID: 203486824 Roni Sedakah

/**
 * The Collidable interface will be used by things that can be collided with.
 */
public interface Collidable {

    /**
     * the collision shape of the object.
     * @return - the collision shage.
     */
    Rectangle getCollisionRectangle();

    /**
     * notify the object that we collided with it a collision point with a given velocity.
     * @param collisionPoint - the collision point.
     * @param currentVelocity - the current velocity.
     * @param hitter - the ball.
     * @return - new velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
