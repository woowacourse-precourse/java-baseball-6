package baseball.controller.input;

import baseball.domain.ball.Balls;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public Balls read() {
        String userInput = Console.readLine();

        return Converter.convert(userInput);
    }

    public boolean isContinue() {
        return switch (Console.readLine()) {
            case "1" -> true;
            case "2" -> {
                Console.close();
                yield false;
            }
            default -> throw new IllegalArgumentException("잘못된 입력입니다.");
        };
    }
}