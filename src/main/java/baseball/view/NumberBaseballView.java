package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballView {

    public void startNumberBaseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
        return userNumber;
    }


}
