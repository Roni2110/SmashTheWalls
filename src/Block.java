//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the blocks of the game, which are a sprites and collidables.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle collisionRectangle;
    private java.awt.Color color;
    private java.util.List<HitListener> hitListeners;


    /**
     * constructor.
     * @param rectangle - the block rectangle.
     * @param color - the color of the block.
     */
    public Block(Rectangle rectangle, java.awt.Color color) {
        this.collisionRectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * constructor.
     * @param rectangle - the block rectangle.
     */
    public Block(Rectangle rectangle) {
        this.collisionRectangle = rectangle;
        this.color = Color.BLUE;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * constructor.
     * @param startPoint - upper- left point of the block.
     * @param width - the block width.
     * @param height - the block height.
     */
    public Block(Point startPoint, double width, double height) {
        this.collisionRectangle = new Rectangle(startPoint, width, height);
        this.color = Color.BLACK;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * setter.
     * @param color - the color that we change to.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.collisionRectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Line[] lines = this.collisionRectangle.lines();
        //check if the collision point is on the upper or bottom lines
        if (lines[0].checkPoint(collisionPoint) || lines[2].checkPoint(collisionPoint)) {
            currentVelocity.changeDy();
            if (!this.hitListeners.isEmpty()) {
                this.notifyHit(hitter);
            }
        }
        //check if the collision point is on the right or left lines
        if (lines[1].checkPoint(collisionPoint) || lines[3].checkPoint(collisionPoint)) {
            currentVelocity.changeDx();
            if (!this.hitListeners.isEmpty()) {
                this.notifyHit(hitter);
            }
        }
        //if there is no collision points with the rectangle, the velocity doesnt change.
        return currentVelocity;
    }

    /**
     * draw thw block on the surface.
     * @param surface - the surface given.
     */
    public void drawOn(DrawSurface surface) {
        this.collisionRectangle.drawOn(surface, this.color);
    }

    @Override
    public void timePassed() {
    }

    /**
     * add the block to the sprite collection and collidable list.
     * @param game - the game to be added.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
        game.addCollidable(this);
    }

    /**
     * remove block from the game by removing from sprite and collidable lists.
     * @param game - the game that we removing the block from.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * notify all listeners when hit happens.
     * @param hitter - the ball that hitting objects.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listenerList = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listenerList) {
            hl.hitEvent(this, hitter);
        }
    }
}
