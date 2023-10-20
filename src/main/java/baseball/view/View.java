package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.view.ViewMessage.*;

public class View {

    public void startGame() {
        System.out.println(START_MESSAGE.getMessage());
    }

    public String playInputNumbers() {
        System.out.print(INPUT_NUMBERS_MESSAGE.getMessage());

        return Console.readLine();
    }

    public void printResult(String result) {
        System.out.println(result);
    }

    public String endGameAndRestartInputNumber() {
        System.out.println(END_MESSAGE.getMessage() + "\n" + INPUT_END_NUMBER.getMessage());

        return Console.readLine();
    }
}
