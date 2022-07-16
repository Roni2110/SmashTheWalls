//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;


/**
 * rectangle class will be aligned with the axes.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private Point[] pointsArr;

    private Color background;




    /**
     * rectangle constructor.
     * @param upperLeft - the upperLeft point of the rectangle.
     * @param width - the rectangle width.
     * @param height - the rectangle height.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.pointsArr = new Point[4];
        this.background = Color.BLACK;

        double pastX = upperLeft.getX();
        double pastY = upperLeft.getY();
        double newX = upperLeft.getX() + width;
        double newY = upperLeft.getY() + height;

        this.pointsArr[0] = upperLeft;
        //upper right point.
        this.pointsArr[1] = new Point(newX, pastY);
        //bootom left point.
        this.pointsArr[2] = new Point(pastX, newY);
        //bottom right point.
        this.pointsArr[3] = new Point(newX, newY);
    }

    /**
     * constructor.
     * @param upperLeft - upper left point.
     * @param width - width.
     * @param height - height.
     * @param color - color.
     */
    public Rectangle(Point upperLeft, int width, int height, Color color) {
        this(upperLeft, width, height);
        this.background = color;
    }

    /**
     * check for intersection points with a given line.
     * @param line - the line being checked.
     * @return - list of intersection points with the line, possibly empty.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        Line[] line1 = lines();
        ArrayList<Point> intersections = new ArrayList<Point>();
        for (int i = 0; i < 3; i++) {
            if (line1[i].isIntersecting(line)) {
                Point point = line1[i].calculatePoint(line);
                if (point != null) {
                    intersections.add(point);
                }
            }
        }
        return intersections;
    }

    /**
     * getter.
     * @return - the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * getter.
     * @return - the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * getter.
     * @return - the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * get the lines of the rectangle.
     * @return array of the rectangle's lines.
     */
    public Line[] lines() {
        Line[] lines = new Line[4];
        //upper line
        lines[0] = new Line(this.pointsArr[0], this.pointsArr[1]);
        //right line
        lines[1] = new Line(this.pointsArr[0], this.pointsArr[2]);
        //bottom line
        lines[2] = new Line(this.pointsArr[2], this.pointsArr[3]);
        //left line
        lines[3] = new Line(this.pointsArr[1], this.pointsArr[3]);
        return lines;
    }

    /**
     * draw the rectangle on the surface.
     * @param surface - the surface given.
     * @param color - the color of the rectangle.
     */
    public void drawOn(DrawSurface surface, java.awt.Color color) {
        int x = (int) this.upperLeft.getX();
        int y = (int) this.upperLeft.getY();
        int width = (int) this.getWidth();
        int height = (int) this.getHeight();
//        surface.setColor(Color.GRAY);
//        surface.drawRectangle(x, y, width, height);
        surface.setColor(color);
        surface.fillRectangle(x + 1, y + 1, width - 1, height - 1);
    }

    /**
     * draw the rectangle on the surface.
     * @param surface - the surface given.
     * @param color - the color given.
     * @param string - the string given to write on the surface.
     */
    public void drawOn(DrawSurface surface, java.awt.Color color, String string) {
        this.drawOn(surface, color);
        if (string != null) {
            surface.setColor(Color.BLACK);
            surface.drawText((int) this.getWidth() / 2 - 15, (int) this.getHeight() - 5, string, 14);
        }
    }

    /**
     * draw rectangle.
     * @param d - surface.
     */
    public void drawOn(DrawSurface d) {
        this.drawOn(d, this.background);
    }
}
