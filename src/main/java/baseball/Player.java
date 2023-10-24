package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Player {
    private final int numberOfDigits;
    private final InputHandler inputHandler;
    private static final String PROMPT_NUMBER_INPUT = "숫자를 입력해주세요 : ";

    public Player(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
        this.inputHandler = new InputHandler();
    }

    public List<Integer> getNumbers() {
        System.out.print(PROMPT_NUMBER_INPUT);
        String input = Console.readLine();
        return inputHandler.handlingAndConvert(input, numberOfDigits);
    }
}

