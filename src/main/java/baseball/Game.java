package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final String RESTART_GAME = "1";
    public static final int NUMBER_SIZE = 3;

    private final AnswerChecker answerChecker;
    private List<Integer> answer;

    public Game() {
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
            Result result = answerChecker.checkGuess(answer, convertInputToList(input));
            System.out.println(result.toString());

            if (done(result)) {
                System.out.printf("%s개의 숫자를 모두 맞히셨습니다! 게임 종료\n", NUMBER_SIZE);
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                input = Console.readLine();
                break;
            }
        }

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
    }

    private List<Integer> convertInputToList(String input) {
        List<Integer> result = new ArrayList<>();

        for (char c : input.toCharArray()) {
            result.add(Character.getNumericValue(c));
        }
        return result;
    }

    private void setRandomNumbers() {
        answer = NumberGenerator.getRandomNumber(NUMBER_SIZE);
    }

    private boolean done(Result result) {
        return result.getStrike() == NUMBER_SIZE;
    }
}
