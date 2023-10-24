package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public String inputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String answer = Console.readLine();

        //TODO: 입력한 숫자 검증 로직 필요

        return answer;
    }
}
