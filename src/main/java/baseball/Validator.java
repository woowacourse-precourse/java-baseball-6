package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static baseball.Const.*;

public class Validator {

    private static final Validator instance = new Validator();

    private Validator() {
    }

    public static Validator getInstance() {
        return instance;
    }

    public static void validateInput(final String input) {
        validateInputDigit(input);

    }

    private static void validateInputDigit(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1~9 이외의 문자가 입력되었습니다.");
        }
    }


    public static void validateCommand(int command) {
        if (command != RESTART_COMMAND && command != FINISH_COMMAND) {
            throw new IllegalArgumentException("게임 완료 명령은 1, 2만 입력될 수 있습니다.");
        }
    }
}
