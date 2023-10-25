package baseball.controller.input;

import baseball.domain.ball.Balls;

import baseball.exception.WrongInputException;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    private Input() {
    }

    private static class InputHelper {
        private static final Input INSTANCE = new Input();
    }

    public static Balls read() {
        return Input.InputHelper.INSTANCE.checkRead();
    }

    private Balls checkRead() {
        String userInput = Console.readLine();

        return Converter.convert(userInput);
    }

    public static boolean isContinue() {
        return Input.InputHelper.INSTANCE.checkContinue();
    }

    private boolean checkContinue() {
        return switch (Console.readLine()) {
            case "1" -> true;
            case "2" -> {
                Console.close();
                yield false;
            }
            default -> throw new WrongInputException("잘못된 입력입니다.");
        };
    }
}