//ID: 203486824 Roni Sedakah
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * game flow class.
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private Counter counter;
    private GUI gui;


    /**
     * constructor.
     * @param ar - animationRunner.
     * @param ks - ketboard sensor.
     * @param g - GUI.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI g) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.counter = new Counter(0);
        this.gui = g;
    }

    /**
     * run all levels.
     * @param levels - list of all the levels we have in the game.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner,
                    this.counter, this.gui);
            level.initialize();
            level.setRunning();
            while (level.isRunning()) {
                level.run();
            }
            if (level.getBallsLeft().getValue() == 0) {
                Animation stopGame = new KeyPressStoppableAnimation(this.keyboardSensor, keyboardSensor.SPACE_KEY,
                        new Failed(this.keyboardSensor, this.counter));
                this.animationRunner.run(stopGame);
                this.gui.close();
                break;
            }
        }
        Animation winGame = new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
                new Win(this.keyboardSensor, this.counter));
        this.animationRunner.run(winGame);
        this.gui.close();
    }

//    public static void main(String[] args) {
//        GUI gui1 = new GUI("THE GAME", 800, 600);
//        GameFlow gameFlow = new GameFlow(new AnimationRunner(gui1), gui1.getKeyboardSensor(), gui1);
//        List<LevelInformation> levelInformations = new ArrayList<>();
//        levelInformations.add(new LeveOneGame());
//        levelInformations.add(new LevelTwoGame());
//        levelInformations.add(new LevelThreeGame());
//        levelInformations.add(new LevelFourGame());
//        gameFlow.runLevels(levelInformations);
//    }
}
