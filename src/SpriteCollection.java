//ID: 203486824 Roni Sedakah
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * sprite collection "collect" all the sprites in our game.
 */
public class SpriteCollection {
    private ArrayList<Sprite> sprites;

    /**
     * constructor.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    /**
     * add sprite to the list.
     * @param s - the sprite being added.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        // Make a copy of the hitListeners before iterating over them.
        List<Sprite> spriteList = new ArrayList<>(this.sprites);
        for (Sprite sprite : spriteList) {
            sprite.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     * @param d - the surface given.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite: this.sprites) {
            sprite.drawOn(d);
        }
    }

    /**
     * remove sprite from sprite collection.
     * @param s - the sprite being removed.
     */
    public void removeFromSpriteList(Sprite s) {
        this.sprites.remove(s);
    }
}
