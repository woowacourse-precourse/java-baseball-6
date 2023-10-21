package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String playerNumberMessage = "숫자를 입력해주세요 : ";

    public void enterGameNumber() {
        System.out.print(playerNumberMessage);
        String playerNumber = Console.readLine();
        System.out.println("playerNumber: " + playerNumber);
    }
}
