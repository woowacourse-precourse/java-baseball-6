package baseball;

import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.util.Converter;
import baseball.util.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static final int SIZE = 3;
    private int ball;
    private int strike;
    List<Integer> computerNumbers;
    List<Integer> userNumbers;
    OutputView outputView = new OutputView();
    Validator validator;
    Converter converter;
    Referee referee;

    public void run() {
        resetGame();
        generateComputerNumbers();
        while (true) {
            String input = requestUserInput();
            initGame();
            checkInputData(input);
            generateUserNumbers(input);
            requestJudge(computerNumbers, userNumbers);
            requestResult(ball, strike);
            if (strike == 3) {
                String retryMessage = requestRetryMessage();
                if (retryMessage.equals("1")) {
                    initGame();
                    generateComputerNumbers();
                }
                if (retryMessage.equals("2")) {
                    break;
                }
            }
        }
    }

    public void initGame() {
        userNumbers = new ArrayList<>();
        validator = new Validator();
        referee = new Referee();
    }

    public void resetGame() {
        computerNumbers = new ArrayList<>();
    }

    private String requestUserInput() {
        InputView.requestInputData();
        String input = Console.readLine();
        System.out.print(input);
        System.out.println();
        return input;
    }

    private void checkInputData(String input) {
        validator.checkValid(input, SIZE);
    }

    private void generateUserNumbers(String input) {
        converter = new Converter(input);
        userNumbers = converter.getSeperatedNumbers();
    }

    private void generateComputerNumbers() {
        Computer computer = new Computer(SIZE);
        computerNumbers = computer.getComputerNumbers();
    }

    private void requestJudge(List<Integer> computerNumbers, List<Integer> userNumbers) {
        referee.judge(computerNumbers, userNumbers);
        ball = referee.getBall();
        strike = referee.getStrike();
    }

    private void requestResult(int ball, int strike) {
        outputView.printJudgement(ball, strike);
    }

    private String requestRetryMessage() {
        OutputView.printEndMessage();
        InputView.printRetryMessage();
        return Console.readLine();
    }
}
