package baseball;

import baseball.global.GameMessage;
import baseball.model.GameInput;
import baseball.model.GameResult;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame implements Game {
    public static final int NUMBER_RANGE_START = 1;
    public static final int NUMBER_RANGE_END = 9;
    public static final int NUMBER_SIZE = 3;

    private final List<Integer> numbers;
    private boolean continueGame = true;
    private boolean win = false;

    public BaseballGame() {
        numbers = new ArrayList<>();
    }

    private void start() {
        System.out.println(GameMessage.BASEBALL_START_GAME);
    }

    public void setting() {
        this.setComputerNumber();
        win = false;
    }

    public void game() {
        // 게임 반복
        while (!win) {
            List<Integer> playerNumbers = getPlayerNumbers();
            GameResult result = compareInputWithComputerNumbers(playerNumbers);

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
        }
        else if (input.equals(GameMessage.END)) {
            continueGame = false;
        }
        else {
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


    private void setComputerNumber() {
        numbers.clear();
        while (numbers.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    private List<Integer> getPlayerNumbers() {
        String playerInput = this.getNumbersString();
        String[] split = playerInput.split("");

        GameInput gameInput = GameInput.from(split);
        return gameInput.getNumbers();
    }

    private String getNumbersString() {
        System.out.println(GameMessage.GET_NUMBER);
        String input = Console.readLine();

        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    private GameResult compareInputWithComputerNumbers(List<Integer> input) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (numbers.get(i).equals(input.get(i))) {
                strike++;
            }
            else {
                if (numbers.contains(input.get(i))) {
                    ball++;
                }
            }
        }
        return GameResult.from(strike, ball);
    }
}
