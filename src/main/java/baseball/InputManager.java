package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.CommandConst.*;

public class InputManager {
    private static InputManager instance;

    private InputManager() {}

    public String readNumber() {
        String inputNumber = Console.readLine();
        validateNumber(inputNumber);
        return inputNumber;
    }

    public String readWeatherRestartOrEnd() {
        String input = Console.readLine();
        validateRestartOrEnd(input);
        return input;
    }

    private void validateNumber(String input) {
        if(!isNumeric(input))
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        if(input.length() != 3)
            throw new IllegalArgumentException("3자리 숫자만 입력해 주세요.");
        if(hasDuplicatedNumber(input)) {
            throw new IllegalArgumentException("중복이 포함되는 숫자는 입력할 수 없어요");
        }
    }

    private void validateRestartOrEnd(String input) {
        String ErrorMessage = String.format("%s또는 %s만 입력이 가능합니다.", GAME_RESTART_COMMAND, GAME_END_COMMAND);
        if(!(input.equals(GAME_RESTART_COMMAND) || input.equals(GAME_END_COMMAND)))
            throw new IllegalArgumentException(ErrorMessage);
    }

    private boolean isNumeric(String str) {
        final String REGEX = "[0-9]+";
        return str.matches(REGEX);
    }

    private boolean hasDuplicatedNumber(String input) {
        Set<Character> set = new HashSet<>();

        for (char c : input.toCharArray())
            set.add(c);

        return input.length() != set.size();
    }

    public static InputManager getInstance() {
        if(instance == null) {
            instance = new InputManager();
        }
        return instance;
    }
}
