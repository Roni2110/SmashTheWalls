//ID: 203486824 Roni Sedakah

import java.util.Comparator;
import java.util.List;

/**
 * class line define a line which connects between two point - has start and end point.
 * Lines have lengths, and may intersect with other lines.
 * It can also tell if it is the same as another line segment.
 */

public class Line {
    private final Point start;
    private final Point end;
    private final double slope;
    private final boolean checkVertical;
    private static final double SMALL = Math.pow(10, -4);


    /**
     * constructor that also check for the line slope.
     * @param start - x,y values of start point.
     * @param end - x,y values of end point.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        //check for the line slope - also check if vertical / horizental
        //check if the line is vertical
        if (end.getX() == start.getX()) {
            this.slope = 0;
            this.checkVertical = true;
        } else {
            //m = (y2-y1)/(x2-x1)
            double up = end.getY() - start.getY();
            double down = end.getX() - start.getX();
            slope = up / down;
            this.checkVertical = false;
        }
    }

    /**
     * constructor - creating the line and calculating the slope.
     * @param x1 - x value of start point.
     * @param y1 - y value of start point.
     * @param x2 - x value of end point.
     * @param y2 - y value of end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        //calculating slope also for this constructor
        if (x1 == x2) {
            this.slope = 0;
            this.checkVertical = true;
        } else {
            //m = (y2-y1)/(x2-x1)
            double up = y2 - y1;
            double down = x2 - x1;
            slope = up / down;
            this.checkVertical = false;
        }
    }

    /**
     * length function.
     * @return the length of the line.
     */
    public double length() {
        return this.start.distance(end);
    }

    /**
     * measure the middle point of the line.
     * @return a new point - which is the middle point of the line.
     */
    public Point middle() {
        return new Point((this.start.getX() + this.end.getX()) / 2, (this.start.getY() + this.end.getY()) / 2);
    }

    /**
     * get start point.
     * @return the start point.
     */
    public Point start() {
        return this.start;
    }

    /**
     * get end point.
     * @return the end point.
     */
    public Point end() {
        return this.end;
    }

    /**
     * isIntersecting function - check if two lines intersect.
     * @param other - another line given.
     * @return true if they intersecting and false otherwise.
     */
    public boolean isIntersecting(Line other) {
        //checking if the lines are parallel
      if (this.checkVertical && other.checkVertical) {
          if (this.start.getX() != other.start.getX()) {
              return false;
          }
          return this.isSameLine(other);
      }
      if (this.slope != other.slope || this.checkVertical || other.checkVertical) {
          Point p = calculatePoint(other);
          return p != null;
      }
      return this.isSameLine(other);
    }

    /**
     * calculate the intersection point.
     * @param other - the line checked on.
     * @return the intersection point.
     */
    public Point calculatePoint(Line other) {
        if (this.start.equals(other.start) || this.start.equals(other.end)) {
            return this.start;
        }
        if (this.end.equals(other.start) || this.end.equals(other.end)) {
            return this.end;
        }
        double xThis = this.end.getX();
        double yThis = this.end.getY();
        double xOther = other.end.getX();
        double yOther = other.end.getY();
        //if one line is vertical
        if (this.checkVertical) {
            double y = yOther + other.slope * xThis - other.slope * xOther;
            Point p = new Point(xThis, y);
            if (this.checkPoint(p) && other.checkPoint(p)) {
                return p;
            }
            return null;
        } else if (other.checkVertical) {
            double y = yThis + this.slope * xOther - this.slope * xThis;
            Point p = new Point(xOther, y);
            if (other.checkPoint(p)) {
                return p;
            }
            return null;
        } else {
            //calculate point intersection
            double x = (other.slope * xOther - this.slope * xThis + yThis - yOther) / (other.slope - this.slope);
            double y = this.slope * x - this.slope * xThis + yThis;
            Point intersection = new Point(x, y);
            //checking if the point found is on the lines
            if (this.checkPoint(intersection) && other.checkPoint(intersection)) {
                return intersection;
            }
        }
        return null;
    }

    /**
     * checks if two lines are the same line.
     * @param other line cheked.
     * @return true if they are the same line, false otherwise.
     */
    public boolean isSameLine(Line other) {
        if (this.equals(other)) {
            return true;
        }
        double x = Math.min(this.start.getX(), this.end.getX());
        double y = Math.min(other.start.getX(), other.end.getX());
        double finale = Math.min(x, y);
        if (finale == this.start.getX() || finale == this.end.getX()) {
            return this.checkPoint(other.start) || this.checkPoint(other.end);
        } else {
            return other.checkPoint(this.start) || other.checkPoint(this.end);
        }
    }

    /**
     * checks if a point is on the line.
     * @param p1 the point checked.
     * @return true if the point is on the line, false otherwise.
     */
    public boolean checkPoint(Point p1) {
        //the case where the point is on one of the edges line
        if (this.checkVertical) {
            if (this.start.getX() != p1.getX()) {
                return false;
            }
            double maxY = Math.max(this.start.getY(), this.end.getY());
            double minY = Math.min(this.start.getY(), this.end.getY());
            return !(p1.getY() < minY) && !(p1.getY() > maxY);
        }
        //the case where x is on the right edge
        double maxX = Math.max(this.start.getX(), this.end.getX());
        double minX = Math.min(this.start.getX(), this.end.getX());
        if (p1.getX() < minX || p1.getX() > maxX) {
            return false;
        }
        //y = mx + n
        double y = this.slope * p1.getX() - this.slope * this.start.getX() + this.start.getY();
        return Math.abs(p1.getY() - y) <= SMALL;
    }

    /**
     * intersectionWith checks for the point where the two line intersect.
     * @param other - a line given.
     * @return the point where the two line intersect.
     */
    public Point intersectionWith(Line other) {
        if (this.slope == other.slope) {
            //checking if one of the lines are vertical
            if (this.checkVertical || other.checkVertical) {
                return this.calculatePoint(other);
            }
            return null;
        }
        return this.calculatePoint(other);
    }

    /**
     * checks if two lines are equals.
     * @param other - a line given.
     * @return true if the lines are the same, false otherwise.
     */
    public boolean equals(Line other) {
        return this.start.equals(other.start) && this.end.equals(other.end)
                || this.end.equals(other.start) && this.start.equals(other.end);
    }

    /**
     * check for the closet intersection point to the start of the rectangle line.
     * @param rect - the rectangle given.
     * @return - the closet point.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> points = rect.intersectionPoints(this);
        if (points.isEmpty()) {
            return null;
        }
        int sizeList = points.size();
        Comparator<Point> comparator = new ComparatorPoint();
        points.sort(comparator);
        if (this.start.getX() > this.end.getY()) {
            return points.get(sizeList - 1);
        } else {
            return points.get(0);
        }
    }
}
