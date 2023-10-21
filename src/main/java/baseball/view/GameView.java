package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    private static final String NUMBER_INPUT_MSG = "숫자를 입력해주세요 : ";

    public String inputUserNumber() {
        System.out.print(NUMBER_INPUT_MSG);
        String userInput = Console.readLine();
        System.out.println("usrInput=" + userInput);

        return userInput;
    }
}
