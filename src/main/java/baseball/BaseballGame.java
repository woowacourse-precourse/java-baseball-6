package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.platform.commons.util.StringUtils;

public class BaseballGame {
    public static final String RESTART_GAME = "1";
    public static final int NUMBER_SIZE = 3;

    private final AnswerChecker answerChecker;
    private List<Integer> answer;

    public BaseballGame() {
        answerChecker = new AnswerChecker();
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    private void startGame() {
        setRandomNumbers();
        String input;

        while (true) {
            System.out.println("숫자를 입력해주세요 :");
            input = Console.readLine();

            validateInput(input);

            GameResult gameResult = answerChecker.calculateGameResult(answer, convertInputToList(input));
            System.out.println(gameResult.toString());

            if (isComplete(gameResult)) {
                handleGameCompletion();
                break;
            }
        }
    }

    private void handleGameCompletion() {
        String input;

        System.out.printf("%s개의 숫자를 모두 맞히셨습니다! 게임 종료\n", NUMBER_SIZE);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        input = Console.readLine();

        if (RESTART_GAME.equals(input)) {
            startGame();
        }
    }

    private void validateInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }

        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException("3글자만 입력할 수 있습니다.");
        }

        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("숫자 이외의 문자가 포함되어 있습니다.");
        }
    }

    private List<Integer> convertInputToList(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    private void setRandomNumbers() {
        answer = NumberGenerator.getRandomNumber(NUMBER_SIZE);
    }

    private boolean isComplete(GameResult gameResult) {
        return gameResult.getStrike() == NUMBER_SIZE;
    }
}
