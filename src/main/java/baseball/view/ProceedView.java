package baseball.view;


import baseball.controller.GameController;
import camp.nextstep.edu.missionutils.Console;

public class ProceedView {

    GameController gameController = new GameController();
    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public void proceed() {
        printEnterNumber();
        gameController.guessNumber(Console.readLine());
    }

    private void printEnterNumber() {
        System.out.println(ENTER_NUMBER_MESSAGE);
    }

    public void printHint(String result) {
        System.out.println(result);
    }

}
