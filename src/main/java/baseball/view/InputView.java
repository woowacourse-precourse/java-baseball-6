package baseball.view;

import baseball.model.GameNumber;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String inputNumberMessage = "숫자를 입력해주세요 : ";

    GameNumber gameNumber = new GameNumber();

    public void enterGameNumber() {
        System.out.print(inputNumberMessage);
        String inputNumber = Console.readLine();
        gameNumber.setInputNumber(inputNumber);
        System.out.println("[GameNumber] inputNumber: " + gameNumber.getInputNumber());
    }
}
