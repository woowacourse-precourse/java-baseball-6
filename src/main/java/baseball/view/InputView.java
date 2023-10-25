package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ILLEGAL_USER_INPUT_MESSAGE = "야구공은 숫자만 입력할 수 있습니다.";
    private static final String ILLEGAL_GAME_INPUT_MESSAGE = "공 번호는 1 또는 2만 입력할 수 있습니다.";
    private static final String NEW_GAME = "1";
    private static final String QUIT = "2";

    public static String inputPlayerBaseBallNumbers() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String playerInput = readLine();
        validatePlayerBaseBallNumber(playerInput);
        return playerInput;
    }

    public static String inputGamePlayNumber() {
        String playNumber = readLine();
        validateGamePlayNumber(playNumber);
        return playNumber;
    }

    private static void validatePlayerBaseBallNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ILLEGAL_USER_INPUT_MESSAGE);
        }
    }

    private static void validateGamePlayNumber(String playNumber) {
        if (!playNumber.equals(NEW_GAME) && !playNumber.equals(QUIT)) {
            System.out.println(ILLEGAL_GAME_INPUT_MESSAGE);
        }
    }
}