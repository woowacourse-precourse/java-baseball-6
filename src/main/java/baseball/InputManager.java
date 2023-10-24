package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private static InputManager instance;
    private InputManager() {}

    public String readNumber() {
        String inputNumber = Console.readLine();
        validateNumber(inputNumber);
        return inputNumber;
    }

    private void validateNumber(String input) {
        if(!isNumeric(input))
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        if(input.length() != 3)
            throw new IllegalArgumentException("3자리 숫자만 입력해 주세요.");
    }

    public int readWeatherRestartOrEnd() {
        String input = Console.readLine();
        validateRestartOrEnd(input);
        return Integer.parseInt(input);
    }

    private void validateRestartOrEnd(String input) {
        if(!(input.equals("1") || input.equals("2")))
            throw new IllegalArgumentException("1또는 2만 입력이 가능합니다.");
    }

    private boolean isNumeric(String str) {
        final String REGEX = "[0-9]+";
        return str.matches(REGEX);
    }

    public static InputManager getInstance() {
        if(instance == null) {
            instance = new InputManager();
        }
        return instance;
    }
}
