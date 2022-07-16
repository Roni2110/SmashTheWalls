//ID: 203486824 Roni Sedakah

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor.
     */
    public Velocity() {
        this.dx = 0;
        this.dy = 0;
    }

    /**
     * velocity constructor.
     * @param dx - the change in x axis.
     * @param dy - the change in y axis.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     * @param p - the point being change.
     * @return a new point with the new velocity.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * get the change in velocity.
     * @return the change in x axis.
     */
    public double getDx() {
        return dx;
    }

    /**
     * get the change in velocity.
     * @return the change in y axis.
     */
    public double getDy() {
        return dy;
    }

    /**
     * specify the velocity in terms of angle and speed.
     * @param angle - the angle.
     * @param speed - the speed of dx/dy.
     * @return new velocity with the changes.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(angle / (180 * Math.PI));
        double dy = speed * Math.cos(angle / (180 * Math.PI));
        return new Velocity(dx, -dy);
    }

    /**
     * change the dx direction.
     */
    public void changeDx() {
        this.dx = this.dx * (-1);
    }

    /**
     * change the dy direction.
     */
    public void changeDy() {
        this.dy = this.dy * (-1);
    }
}
