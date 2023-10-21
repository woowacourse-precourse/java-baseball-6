package baseball.baseball.controller;

import baseball.baseball.model.BaseballService;
import baseball.baseball.util.StringConvertUtil;
import baseball.baseball.view.InputView;
import baseball.baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private static final BaseballService baseballService = new BaseballService();
    private static final OutputView outputView = OutputView.getInstance();
    private static final InputView inputView = InputView.getInstance();
    private static List<Integer> goalNumber;
    private static final String SUCCESS_MESSAGE = "3스트라이크";

    public void run() {
        start();
    }

    private void start() {
        outputView.printStartGame();
        goalNumber = baseballService.createGoalNumber();

        // 테스트용 정답 번호 출력
        System.out.println("goalNumber = " + goalNumber);

        game();
    }

    private void game(){
        boolean isEndGame = false;

        while (!isEndGame) {
            List<Integer> inputNumber = getInputNumber();

            String hint = checkNumber(inputNumber);
            outputView.printHint(hint);

            isEndGame = hint.equals(SUCCESS_MESSAGE);
        }
    }

    private List<Integer> getInputNumber(){
        String inputString = inputView.getInputNumber();

        if (inputString.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
        }

        return StringConvertUtil.stringToIntList(inputString);
    }

    private String checkNumber(List<Integer> inputNumber) {
        return baseballService.checkNumber(goalNumber, inputNumber);
    }
}
