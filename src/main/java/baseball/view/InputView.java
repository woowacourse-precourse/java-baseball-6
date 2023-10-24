package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    //숫자 입력받기
    public static String input(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return input;
    }

}
