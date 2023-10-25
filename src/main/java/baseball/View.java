package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class View {

    private static final String DEMAND_GUESS = "숫자를 입력해주세요 : ";
    private static final String DEMAND_RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String EMPTY_STRING = "";
    private static final String SPACE = " ";
    private static final String ERROR_ONLY_NUMBER_INPUT_AVAILABLE = "숫자만 입력 가능합니다.";
    private static final String ERROR_ONLY_1_OR_2_AVAILABLE = "1 또는 2만 입력 가능합니다.";

    public View() {
        println(GAME_START);
    }

    public List<Integer> askGuess() {
        print(DEMAND_GUESS);
        return inputToNumbers(Console.readLine());
    }

    public GameStatus askRestartOrEnd() {
        println(END_GAME);
        println(DEMAND_RESTART_OR_END);
        return getGameStatus(Console.readLine());
    }

    public void showGuessResult(int strikeCount, int ballCount) {
        if (isNothing(strikeCount, ballCount)) {
            println(NOTHING);
            return;
        }
        println(ballCountOutput(ballCount) + strikeCountOutput(strikeCount));
    }

    private List<Integer> inputToNumbers(String inputString) {
        List<Integer> numbers = new ArrayList<>();
        for (char inputChar : inputString.toCharArray()) {
            numbers.add(toNumber(inputChar));
        }
        return numbers;
    }

    private boolean isNothing(int strikeCount, int ballCount) {
        return strikeCount == 0 && ballCount == 0;
    }

    private GameStatus getGameStatus(String inputString) {
        return GameStatus.getBy(inputString)
                .orElseThrow(() -> new IllegalArgumentException(ERROR_ONLY_1_OR_2_AVAILABLE));
    }

    private String ballCountOutput(int ballCount) {
        if (ballCount < 1) {
            return EMPTY_STRING;
        }
        return ballCount + BALL + SPACE;
    }

    private String strikeCountOutput(int strikeCount) {
        if (strikeCount < 1) {
            return EMPTY_STRING;
        }
        return strikeCount + STRIKE;
    }

    private void validateIsNumber(char inputChar) {
        if (!Character.isDigit(inputChar)) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER_INPUT_AVAILABLE);
        }
    }

    private int toNumber(char character) {
        validateIsNumber(character);
        return Character.getNumericValue(character);
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.print(message);
    }
}
