package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String inputUserNumberMessage = "숫자를 입력해주세요 : ";

    public String inputUserNumber(){
        System.out.println(inputUserNumberMessage);
        return Console.readLine();
    }
}
