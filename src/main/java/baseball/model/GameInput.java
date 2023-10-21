package baseball.model;

import camp.nextstep.edu.missionutils.Console;

public class GameInput {
    private final Integer RESTART_GAME = 1;
    private final Integer END_GAME = 2;

    public Number readNumberInput() {
        int number = Integer.parseInt(Console.readLine());
        return new Number(number);
    }

    public Integer readFinishInput() {
        int number = Integer.parseInt(Console.readLine());

        switch (number) {
            case 1:
                return RESTART_GAME;
            case 2:
                return END_GAME;
            default:
                throw new IllegalArgumentException("1 또는 2를 입력해야합니다.");
        }
    }

}
