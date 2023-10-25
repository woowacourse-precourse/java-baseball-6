package baseball;

import static baseball.Validator.validInputSize;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public static final String REQUEST_NUMBERS = "숫자를 입력해주세요 : ";

    private final Picks picks = new Picks();

    public Picks makePicks() {
        String input = loadInput();
        picks.createPicks(input);
        return picks;
    }

    private String loadInput() {
        System.out.printf(REQUEST_NUMBERS);
        String input = Console.readLine();
        validInputSize(input);
        return input;
    }

    public Picks getPicks() {
        return picks;
    }
}
