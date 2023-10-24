package baseball.view;

import camp.nextstep.edu.missionutils.*;

public class UserInputView {

    //    사용자 숫자 입력
    public static String getUserInputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    //    게임 재시작 숫자 입력
    public static String getUserInputRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

}
