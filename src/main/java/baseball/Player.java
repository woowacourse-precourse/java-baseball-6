package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public static final String ASK_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private final Balls balls = new Balls();

    public Balls makeBalls() {
        String input = getInput();
        balls.createBalls(input);
        return balls;
    }

    private String getInput() {
        System.out.printf(ASK_INPUT_MESSAGE);
        String input = Console.readLine();

        Validator.validInputLength(input);
        return input;
    }

    public Balls getBalls() {
        return balls;
    }
}
