package baseball.player;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private final String INPUT_NUM_REGEX = "[1-9]{3}";

    public Player() {
    }

    public String input() {
        System.out.print("숫자를 입력해주세요 : ");
        String num = Console.readLine();
        if (!num.matches(INPUT_NUM_REGEX)) {
            throw new IllegalArgumentException();
        }
        return num;
    }
}
