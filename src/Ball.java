//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * crating the ball of the game.
 */
public class Ball implements Sprite {
    private Point center;
    private final int r;
    private final Color color;
    private Velocity velocity;
    private int topBorder;
    private int bottomBorder;
    private int rightBoarder;
    private int leftBoarder;
    private GameEnvironment gameEnvironment;

    /**
     * constructor.
     * @param center - the center of the ball.
     * @param r - the radius of the ball.
     * @param color - the color of the ball.
     * @param g - game environment.
     */
    public Ball(Point center, int r, Color color, GameEnvironment g) {
        this.center = center;
        this.r = r;
        this.gameEnvironment = g;
        this.color = color;
        this.velocity = new Velocity();
    }

    /**
     * ball constructor.
     * @param center - center point of the ball - has value x,y.
     * @param r - the radius of the ball.
     * @param color - the color of the ball.
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.velocity = new Velocity();
    }

    /**
     * accessor to x value of center point.
     * @return x value.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * accessor to y value of center point.
     * @return y value.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * getter.
     * @return radius.
     */
    public int getR() {
        return r;
    }

    /**
     * accessor to the radius of the ball.
     * @return the radius.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * accessor to the color of the ball.
     * @return the color.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * draw the ball on the given surface.
     * @param surface surface given.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * set the velocity of the ball.
     * @param v - the new velocity.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * set the velocity of the ball in x,y axis.
     * @param dx - ths change in x axis.
     * @param dy - the change in y axis.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * accessor to velocity.
     * @return the velocity.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * set the frame boundaries.
     * @param up - the upper boundary.
     * @param down - the bottom boundary.
     * @param left - the left boundary.
     * @param right - the right boundary.
     */
    public void setFrame(int up, int down, int left, int right) {
        this.topBorder = up;
        this.leftBoarder = left;
        this.bottomBorder = down;
        this.rightBoarder = right;
    }

    /**
     * change the ball's center according to the ball velocity.
     * if there is a closes collision with the line, then checking for the closes point to the collision point.
     * if there is no colses collision with the line, then the ball remain the same.
     */
    public void moveOneStep() {
        Point point = this.getVelocity().applyToPoint(this.center);
        Line line = new Line(this.center, point);
        CollisionInfo info = this.gameEnvironment.getClosestCollision(line);
        if (info != null) {
            this.center = beforeCollision(info.collisionPoint());
            this.velocity = info.collisionObject().hit(this, info.collisionPoint(), this.velocity);
        } else {
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }

    /**
     * checking for the point that is closes to collision point.
     * @param point - the collision point.
     * @return - a new point, closes to the collision point.
     */
    public Point beforeCollision(Point point) {
        double x = point.getX();
        double y = point.getY();
        if (this.center.getX() > point.getX()) {
            x = point.getX() + this.r + 1;
        } else if (this.center.getX() < point.getX()) {
            x = point.getX() - this.r - 1;
        }
        if (this.center.getY() > point.getY()) {
            y = point.getY() + this.r + 1;
        } else if (this.center.getY() < point.getY()) {
            y = point.getY() - this.r - 1;
        }
        return new Point(x, y);
    }
    //    /**
    //     * change the ball's center according to the ball velocity.
    //     */
    //    public void moveOneStep() {
    //        if (this.center.getX() + this.r + this.getVelocity().getDx() >= this.rightBoarder) {
    //            this.setVelocity(-this.getVelocity().getDx(), this.getVelocity().getDy());
    //            this.center = this.getVelocity().applyToPoint(this.center);
    //        }
    //        if (this.center.getX() - this.r + this.getVelocity().getDx() <= this.leftBoarder) {
    //            this.setVelocity(-this.getVelocity().getDx(), this.getVelocity().getDy());
    //            this.center = this.getVelocity().applyToPoint(this.center);
    //        }
    //        if (this.center.getY() + this.r + this.getVelocity().getDy() >= this.bottomBorder) {
    //            this.setVelocity(this.getVelocity().getDx(), -this.getVelocity().getDy());
    //            this.center = this.getVelocity().applyToPoint(this.center);
    //        }
    //        if (this.center.getY() - this.r + this.getVelocity().getDy() <= this.topBorder) {
    //            this.setVelocity(this.getVelocity().getDx(), -this.getVelocity().getDy());
    //            this.center = this.getVelocity().applyToPoint(this.center);
    //        }
    //        this.center = this.getVelocity().applyToPoint(this.center);
    //    }

    /**
     * draw the ball on the surface.
     * @param start - the point where the ball will start.
     * @param dx - velocity in x axis.
     * @param dy - velocity in y axis.
     */
    public void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI("title", 200, 200);
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball(new Point(start.getX(), start.getY()), 30, Color.BLACK);
        ball.setVelocity(dx, dy);
        ball.setFrame(0, 200, 0, 200);
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }

    /**
     * add the ball to the sprite collection.
     * @param game - the game to be added.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    /**
     * remove ball from the game.
     * @param game - the game.
     */
    public void removeBallFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}