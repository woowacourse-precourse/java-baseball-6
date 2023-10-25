package baseball.game;

import baseball.exception.ExceptionHandler;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GamePlayer {
    private final ExceptionHandler exceptionHandler = new ExceptionHandler();

    protected List<Integer> userAnswerInput() {

        String[] userInputToStringArray;

        List<Integer> userInputToArrayListInteger = new ArrayList<>();

        try {
            userInputToStringArray = exceptionHandler
                    .exceptionHandler(Console.readLine())
                    .split("");
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }

        for (String string : userInputToStringArray) {
            userInputToArrayListInteger.add(Integer.parseInt(string));
        }

        return userInputToArrayListInteger;
    }

    protected String userRestartInput() {

        String userRestartInput;

        try {
            userRestartInput = exceptionHandler
                    .userElseInputAfterEndPhraseException(Console.readLine());
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException();
        }

        return userRestartInput;
    }
}
