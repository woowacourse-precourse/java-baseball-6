package baseball;

import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.util.Converter;
import baseball.util.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static final int SIZE = 3;
    public static final String RETRY = "1";
    private String userNumber;
    List<Integer> computerNumbers;
    List<Integer> userNumbers;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Validator validator;
    Converter converter;
    Referee referee;

    public void run() {
        init();
        play();
        end();
    }

    public void init() {
        initComputerNumbers();
        generateComputerNumbers();
    }

    public void play() {
        int strike = 0;
        while (strike != 3) {
            initGame();
            inputUserNumber();
            checkInputData();
            generateUserNumbers();
            requestJudge(computerNumbers, userNumbers);
            strike = referee.getStrike();
            requestResult(referee.getBall(), strike);
        }
    }

    public void end() {
        OutputView.printEndMessage();
        String message = InputView.printRetryMessage();
        if (message.equals(RETRY)) {
            run();
        }
    }

    private void initComputerNumbers() {
        computerNumbers = new ArrayList<>();
    }

    private void generateComputerNumbers() {
        Computer computer = new Computer(SIZE);
        computerNumbers = computer.getComputerNumbers();
    }


    private void initGame() {
        userNumbers = new ArrayList<>();
        validator = new Validator();
        referee = new Referee();
    }

    private void inputUserNumber() {
        userNumber = inputView.inputNumber();
    }

    private void checkInputData() {
        validator.checkValid(userNumber, SIZE);
    }

    private void generateUserNumbers() {
        converter = new Converter(userNumber);
        userNumbers = converter.getSeperatedNumbers();
    }

    private void requestJudge(List<Integer> computerNumbers, List<Integer> userNumbers) {
        referee.judge(computerNumbers, userNumbers);
    }

    private void requestResult(int ball, int strike) {
        outputView.printJudgement(ball, strike);
    }
}
