package baseball.view;

import baseball.controller.GameController;
import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private final GameController controller = new GameController();

    public void inputUserNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        controller.gameProcess(number);
    }
}
