package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInputView {

    public String requestNumberInput(){
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}
