package baseball.controller;

import baseball.domain.RandomNum;
import baseball.domain.Referee;
import baseball.model.Array;
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
        Array.checkArrayNumber(userNumber);
        Array.checkArrayLength(userNumber);
        Array.checkRange(userNumber);
    }

    public String inputNumber() {
        OutputView.inputNumberMessage();
        String inputNum = InputView.number(); // 서로 다른 3개의 숫자 입력

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
        Array.checkArrayNumber(userInput);
        Array.checkOneOrTwo(userInput);

        if (userInput.equals("2")) {
            return QUIT;
        }
        return CONTINUE;
    }

    public boolean isAllStrike(Result result) {
        if (result.getStrike() == 3 && result.getBall() == 0) {
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

            result = getResult(computer, player); // 볼, 스트라이크 세기
            printResult(result); // 출력

        } while (!isAllStrike(result));
    }
}
