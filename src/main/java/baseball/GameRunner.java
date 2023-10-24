package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameRunner {

    public static Game game;

    private GameRunner() {

    };

    private static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    public static void gameStart() {
        System.out.println(Message.START_MSG);
    }

    public static void makeNumbers() {
        game = getInstance();
    }

    public static void readInput() {
        System.out.print(Message.INPUT_MSG);
        String input = Console.readLine();
        game.setUserNumbers(input);
    }

    public static void count() {
        game.count();
    }

    public static void printResult() {
        System.out.println(game.getResultString());
    }

    public static boolean isEnd() {
        if(game.getStrike() == 3) {
            System.out.println(Message.SUCCESS_MSG);
            String input = Console.readLine();
            if(game.checkRestart(input)){
                game = null;
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
