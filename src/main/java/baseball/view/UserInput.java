package baseball.view;

import baseball.controller.GameController;
import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public String inputUserNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}
