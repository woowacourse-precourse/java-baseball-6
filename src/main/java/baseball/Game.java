package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {
    public List<Integer> getUserNum() {
        System.out.println("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
        Utils.validateStringNaturalNumberLengthDuplicate(userNumber);
        return Utils.stringToNumberList(userNumber);
    }
}
