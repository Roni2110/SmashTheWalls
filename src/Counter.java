//ID: 203486824 Roni Sedakah

/**
 * counter class. (charge on counting score,balls,blocks).
 */
public class Counter {
    private int value;

    /**
     * constructor.
     * @param v - value.
     */
    public Counter(int v) {
        this.value = v;
    }

    /**
     * add number to current count.
     * @param number - the number being added.
     */
    public void increase(int number) {
        this.value = this.value + number;
    }

    /**
     * subtract number from current count.
     * @param number - the number being subtract.
     */
    public void decrease(int number) {
        this.value = this.value - number;
    }

    /**
     * getter.
     * @return - value.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * setter.
     * @param value - the value we change to.
     */
    public void setValue(int value) {
        this.value = value;
    }
}
