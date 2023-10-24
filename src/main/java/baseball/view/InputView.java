package baseball.view;

import baseball.model.PlayerNumber;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    PlayerNumber playerNumber = new PlayerNumber();

    public void readGameNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String inputNumber = Console.readLine();

        playerNumber.setInputNumber(inputNumber);
        System.out.println("inputNumber : " + playerNumber.convertStringToInt(inputNumber));
    }
}
