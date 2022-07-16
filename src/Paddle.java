//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * the paddle of the game, which the player control by keyboard sensor.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private int velocity;


    /**
     * constructor.
     * @param keyboardSensor - keyboard.
     * @param width - paddle width.
     * @param speed - paddle speed.
     */
    public Paddle(biuoop.KeyboardSensor keyboardSensor, int width, int speed) {
        this.keyboard = keyboardSensor;
        int paddleWidth = 200;
        int paddleHeight = 10;
        Point upperLeft = new Point(300, 585);
        rectangle = new Rectangle(upperLeft, paddleWidth, paddleHeight);
        this.velocity = speed;
    }

    /**
     * move the paddle to the left.
     */
    public void moveLeft() {
        Point p = new Point(this.rectangle.getUpperLeft().getX() - 4, this.rectangle.getUpperLeft().getY());
        this.rectangle = new Rectangle(p, this.rectangle.getWidth(), this.rectangle.getHeight());
    }

    /**
     * move the paddle to the right.
     */
    public void moveRight() {
        Point p = new Point(this.rectangle.getUpperLeft().getX() + 4, this.rectangle.getUpperLeft().getY());
        this.rectangle = new Rectangle(p, this.rectangle.getWidth(), this.rectangle.getHeight());
    }


    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double calculSpeed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        double dividePaddle = this.rectangle.getWidth() / 5;
        double startPointX = this.rectangle.getUpperLeft().getX();
        double collision = collisionPoint.getX();

        for (int i = 1; i < 4; i++) {
            if (this.rectangle.lines()[i].checkPoint(collisionPoint)) {
                currentVelocity.changeDx();
                currentVelocity.changeDy();
                return currentVelocity;
            }
        }
        //if the collision point is on the first section
        if (collision < startPointX + dividePaddle) {
            return Velocity.fromAngleAndSpeed(300, calculSpeed);
        }
        //if the collision point is on the second section.
        if (collision > startPointX + dividePaddle && collision < startPointX + 2 * dividePaddle) {
            return Velocity.fromAngleAndSpeed(330, calculSpeed);
        }
        //if the collision point is in the middle section.
        if (collision > startPointX + 2 * dividePaddle && collision < startPointX + 3 * dividePaddle) {
            currentVelocity.changeDy();
            return currentVelocity;
        }
        //if the collision point is on the fourth section.
        if (collision > startPointX + 3 * dividePaddle && collision < startPointX + 4 * dividePaddle) {
            return Velocity.fromAngleAndSpeed(30, calculSpeed);
        }
        //if the collision point is on the fifth section.
        return Velocity.fromAngleAndSpeed(60, calculSpeed);
    }

    @Override
    public void drawOn(DrawSurface d) {
        this.rectangle.drawOn(d, Color.MAGENTA);
    }

    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            if (this.rectangle.getUpperLeft().getX() > 5) {
                this.moveLeft();
            }
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            if (this.rectangle.getUpperLeft().getX() < 795 - this.rectangle.getWidth()) {
                this.moveRight();
            }
        }
    }

    /**
     * add the paddle to the sprite collection and collidable list.
     * @param g - the game to be added.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
