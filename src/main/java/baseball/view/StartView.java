package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class StartView {
    public static void beginMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static String requestUserInput(){
        System.out.print("숫자를 입력해 주세요");
        return Console.readLine();
    }
}
