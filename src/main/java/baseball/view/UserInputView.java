package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInputView {

    public void requestNumberInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
    }
}
