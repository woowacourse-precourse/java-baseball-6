package baseball;

import camp.nextstep.edu.missionutils.Console;

public class PlayGame {
    String userInputNumber;

    public String inputRandomBall(){
        System.out.print("숫자를 입력해주세요 : ");
        userInputNumber = Console.readLine();

        return userInputNumber;
    }
}
