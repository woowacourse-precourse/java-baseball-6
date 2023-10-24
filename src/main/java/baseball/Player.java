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

    // 입력된 문자에 대해 예외 처리 및 숫자로 변환
    public List<Integer> getNumbers() {
        System.out.print(PROMPT_NUMBER_INPUT);
        String input = Console.readLine();
        return inputHandler.handlingAndConvert(input, numberOfDigits);
    }
}

