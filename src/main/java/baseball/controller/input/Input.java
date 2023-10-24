package baseball.controller.input;

import baseball.domain.ball.Balls;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final Converter converter = Converter.getInstance();

    public Balls read() {
        String userInput = Console.readLine();

        return converter.convert(userInput);
    }
}