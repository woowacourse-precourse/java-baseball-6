package baseball.controller;

import baseball.domain.RandomNum;
import baseball.domain.Referee;
import baseball.domain.Validator;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGame {
    private static final String CONTINUE = "1";
    private static final String QUIT = "2";
    private static String isContinue = CONTINUE;

    public BaseballGame() {
    }

    public List<Integer> createRandomNum() {
        RandomNum randomNum = new RandomNum();
        return randomNum.create();
    }

    public void checkInput(String userNumber) {
        Validator.checkArrayNumber(userNumber);
        Validator.checkArrayLength(userNumber);
        Validator.checkRange(userNumber);
    }

    public String inputNumber() {
        OutputView.inputNumberMessage();
        String inputNum = InputView.number();

        checkInput(inputNum);

        return inputNum;
    }

    public Result getResult(Computer computer, Player player) {
        Referee referee = new Referee();

        return referee.compare(computer.getComputerNumbers(), player.getUserNumbers());
    }

    public String startNewGame() {
        String userInput;
        OutputView.restartCheckMessage();

        userInput = InputView.number();
        Validator.checkArrayNumber(userInput);
        Validator.checkOneOrTwo(userInput);

        if (userInput.equals("2")) {
            return QUIT;
        }
        return CONTINUE;
    }

    public boolean isAllStrike(Result result) {
        if (result.getStrike() == 3 && result.getBall() == 0) {
            OutputView.allStrikeMessage();
            isContinue = startNewGame();
            return true;
        }
        return false;
    }

    public void printResult(Result result) {
        System.out.println(result.print());
    }

    public void play() {
        OutputView.startGameMessage();
        do {
            game();
        } while (isContinue.equals(CONTINUE));
    }

    public void game() {
        Computer computer = new Computer();
        computer.setComputerNumbers(createRandomNum());

        Result result;
        do {
            Player player = new Player();
            List<Integer> playerNumbers = player.checkDuplication(inputNumber());
            player.setUserNumbers(playerNumbers);

            result = getResult(computer, player);
            printResult(result);

        } while (!isAllStrike(result));
    }
}
