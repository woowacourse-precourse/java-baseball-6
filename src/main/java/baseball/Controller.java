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
    public static final String RETRY = "1";
    private String inputData;
    List<Integer> computerNumbers;
    List<Integer> userNumbers;
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
            requestUserInputData();
            checkInputData();
            generateUserNumbers();
            requestJudge(computerNumbers, userNumbers);
            strike = referee.getStrike();
            requestResult(referee.getBall(), strike);
        }
    }

    public void end() {
        OutputView.printEndMessage();
        InputView.printRetryMessage();
        String message = Console.readLine();
        System.out.println(message);
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

    private void requestUserInputData() {
        InputView.requestInputData();
        inputData = Console.readLine();
        System.out.println(inputData);
    }

    private void checkInputData() {
        validator.checkValid(inputData, SIZE);
    }

    private void generateUserNumbers() {
        converter = new Converter(inputData);
        userNumbers = converter.getSeperatedNumbers();
    }

    private void requestJudge(List<Integer> computerNumbers, List<Integer> userNumbers) {
        referee.judge(computerNumbers, userNumbers);
    }

    private void requestResult(int ball, int strike) {
        outputView.printJudgement(ball, strike);
    }
}
