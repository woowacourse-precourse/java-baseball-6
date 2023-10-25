package baseball.service;

import baseball.global.GameMessage;
import baseball.model.Computer;
import baseball.model.GameInput;
import baseball.model.GameResult;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGame implements Game {
    public static final int NUMBER_RANGE_START = 1;
    public static final int NUMBER_RANGE_END = 9;
    public static final int NUMBER_SIZE = 3;

    private final Computer computer;
    private boolean continueGame = true;
    private boolean win = false;

    public BaseballGame() {
        this.computer = new Computer();
    }

    private void start() {
        System.out.println(GameMessage.BASEBALL_START_GAME);
    }

    public void setting() {
        computer.generateNumber();
        win = false;
    }

    public void game() {
        while (!win) {
            List<Integer> playerNumbers = getPlayerNumbers();
            GameResult result = computer.compareWithInput(playerNumbers, NUMBER_SIZE);

            System.out.println(result.getMessage());

            if (result.isEnd(NUMBER_SIZE)) {
                System.out.println(NUMBER_SIZE + GameMessage.BASEBALL_WIN_GAME);
                win = true;
            }
        }
    }

    public void end() {
        System.out.println(GameMessage.BASEBALL_RESTART);
        String input = Console.readLine();

        if (input.equals(GameMessage.RESTART)) {
            continueGame = true;
        } else if (input.equals(GameMessage.END)) {
            continueGame = false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void execute() {
        this.start();

        while (continueGame) {
            this.setting();
            this.game();
            this.end();
        }
    }


    private List<Integer> getPlayerNumbers() {
        String playerInput = this.getNumbersString();
        String[] split = playerInput.split("");

        GameInput gameInput = GameInput.from(split);
        return gameInput.getNumbers();
    }

    private String getNumbersString() {
        System.out.print(GameMessage.GET_NUMBER);
        String input = Console.readLine();

        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }

        return input;
    }
}
