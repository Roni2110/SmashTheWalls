//ID: 203486824 Roni Sedakah


/**
 * class Point has x and y values, and can measure the distance to other points,
 * and if it is equal to another point.
 */

public class Point {
    private static final double SMALL = Math.pow(10, -4);
    private final double x;
    private final double y;

    /**
     * constructor.
     * @param x - the x axis value of the point.
     * @param y - the y axis value of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * distance function - measure the distance between two points.
     * @param other - point given.
     * @return the distance between this and other.
     */
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y)));
    }

    /**
     * equals function - check whether two points are equal.
     * @param other - point given.
     * @return true if other and this are equal, false otherwise.
     */
    public boolean equals(Point other) {
        return !(Math.abs(this.x - other.x) > SMALL) && !(Math.abs(this.y - other.y) > SMALL);
    }

    /**
     * get x function.
     * @return x value of the point.
     */
    public double getX() {
        return x;
    }

    /**
     * get y function.
     * @return y value of the point.
     */
    public double getY() {
        return y;
    }
}
