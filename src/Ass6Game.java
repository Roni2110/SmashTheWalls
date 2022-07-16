//ID: 203486824 Roni Sedakah
import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * run the game.
 */
public class Ass6Game {

    /**
     * main.
     * @param args - the level we want to play.
     */
    @SuppressWarnings("checkstyle:MissingSwitchDefault")
    public static void main(String[] args) {
        List<LevelInformation> levelInformationList = new ArrayList<>();
        levelInformationList.add(new LeveOneGame());
        levelInformationList.add(new LevelTwoGame());
        levelInformationList.add(new LevelThreeGame());
        levelInformationList.add(new LevelFourGame());

        List<LevelInformation> levelsByOrder = new ArrayList<>();
        if (args.length == 0) {
            levelsByOrder = levelInformationList;
        } else {
            for (String x : args) {
                if (x.equals("1")) {
                    levelsByOrder.add(levelInformationList.get(0));
                } else if (x.equals("2")) {
                    levelsByOrder.add(levelInformationList.get(1));
                } else if (x.equals("3")) {
                    levelsByOrder.add(levelInformationList.get(2));
                } else if (x.equals("4")) {
                    levelsByOrder.add(levelInformationList.get(3));
                }
            }
        }

        if (levelsByOrder.isEmpty()) {
            levelsByOrder = levelInformationList;
        }

        GUI gui = new GUI("MY GAME", 800, 600);
        GameFlow gameFlow = new GameFlow(new AnimationRunner(gui), gui.getKeyboardSensor(), gui);
        gameFlow.runLevels(levelsByOrder);
    }

}
