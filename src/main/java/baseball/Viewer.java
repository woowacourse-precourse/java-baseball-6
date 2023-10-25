package baseball;


import static camp.nextstep.edu.missionutils.Console.readLine;

public class Viewer {
    static final String INPUT_ONLY_NUMBER = "숫자만 입력해주세요.";
    public static int readNumber() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBER);
        }
    }

    public static String readNumbers() {
        try {
             int numbers = Integer.parseInt(readLine());
             return String.valueOf(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBER);
        }
    }
}
