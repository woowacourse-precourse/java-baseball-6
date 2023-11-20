package baseball.controller;

import baseball.model.Number;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballController {
    private static final int BASEBALL_LENGTH = 3;
    private static final int BASEBALL_STRIKE_COUNT = 3;
    private static final int ZERO = 0;
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼 ";
    private static final String NOTHING = "낫싱";
    private static final String BASEBALL_RESTART = "1";
    private static final String BASEBALL_END = "2";
    private static final String ERROR_MESSAGE = "1 혹은 2만 입력 가능합니다.";
    private int strikeCount;
    private int ballCount;

    Number number = new Number();
    Random random = new Random();

    OutputView outputView = new OutputView();

    public void start() {
        boolean state = true;
        OutputView.startMessge();
        while (state) {
            setComputerNumbers();
            repeatGame();
            state = restartGame();
        }
    }

    public void repeatGame() {
        while (true) {
            setPlayerNumbers();
            compareNumber();
            hint();
            if (strikeCount == BASEBALL_STRIKE_COUNT) {
                OutputView.endMessage();
                return;
            }
        }

    }

    public void setPlayerNumbers() {
        number.setPlayerNumber(InputView.inputNumber());
        List<Integer> playerNumbers = new ArrayList<>();
        for (int i = 0; i < number.getPlayerNumber().length(); i++) {
            int num = Character.getNumericValue(number.getPlayerNumber().charAt(i));
            playerNumbers.add(num);
        }
        number.setPlayerNumbers(playerNumbers);
    }


    public void setComputerNumbers() {
        number.setComputerNumbers(random.createRandomNumbers());

    }


    public void compareNumber() {
        List<Integer> computer = number.getComputerNumbers();
        List<Integer> player = number.getPlayerNumbers();
        strikeCount = ZERO;
        ballCount = ZERO;
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            strikeCount(computer.get(i), player.get(i));
            ballCount(computer, player.get(i), i);
        }

    }

    public void strikeCount(int computer, int player) {
        if (computer == player) {
            strikeCount++;
        }
    }

    public void ballCount(List<Integer> computer, int player, int index) {
        if (computer.get(index) != player && computer.contains(player)) {
            ballCount++;
        }

    }

    public void hint() {
        String message = "";
        message += ballHint();
        message += strikeHint();
        message += noting();
        outputView.baseballHint(message);

    }

    public String strikeHint() {
        if (strikeCount > 0) {
            return strikeCount + STRIKE;
        }
        return "";


    }

    public String ballHint() {
        if (ballCount > 0) {
            return ballCount + BALL;
        }
        return "";
    }

    public String noting() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;

        }
        return "";
    }

    public boolean restartGame() {
        String plyerChoice = InputView.resetGame();
        if (plyerChoice.equals(BASEBALL_RESTART)) {
            return true;
        } else if (plyerChoice.equals(BASEBALL_END)) {
            return false;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE);

    }


}
