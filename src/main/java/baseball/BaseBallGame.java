package baseball;

import static error.ErrorMessage.INVALID_INPUT_COMMAND;

import camp.nextstep.edu.missionutils.Console;
import generator.RandomGenerator;
import generator.RandomNumberGenerator;
import input.BaseBallGameUserInput;
import input.UserInput;
import java.util.List;
import matcher.BaseBallGameInputMatcher;
import matcher.InputMatcher;

public class BaseBallGame {
    private final RandomGenerator<List<Integer>> randomNumberGenerator = new RandomNumberGenerator();
    private final UserInput<List<Integer>> baseBallUserInput = new BaseBallGameUserInput();
    private final InputMatcher<List<Integer>, List<Integer>> baseBallGameInputMatcher = new BaseBallGameInputMatcher();
    private final static String START_GAME_CODE = "1";
    private final static String STOP_GAME_CODE = "2";
    private final static String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final static String END_GAME_MESSAGE = "%s개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String RESTART_GAME_MESSAGE = String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.",
            START_GAME_CODE, STOP_GAME_CODE);
    private final Integer gameSize;

    public BaseBallGame(Integer gameSize) {
        this.gameSize = gameSize;
    }

    public void startGame() {
        System.out.println(START_GAME_MESSAGE);
        do {
            final List<Integer> randomNumberList = randomNumberGenerator.generate(gameSize);
            List<Integer> userInput;
            do {
                userInput = baseBallUserInput.input(gameSize);
                baseBallGameInputMatcher.match(userInput, randomNumberList);
            } while (checkMatching());
        } while (checkContinuationGame());
        baseBallUserInput.close();
    }

    private boolean checkMatching() {
        if (baseBallGameInputMatcher.isAllMatched()) {
            System.out.println(String.format(END_GAME_MESSAGE, gameSize));
            return false;
        }
        return true;
    }

    private Boolean checkContinuationGame() {
        System.out.println(RESTART_GAME_MESSAGE);
        final String inputString = Console.readLine();
        if (inputString.equals(START_GAME_CODE)) {
            return true;
        }
        if (inputString.equals(STOP_GAME_CODE)) {
            return false;
        }
        throw new IllegalArgumentException(INVALID_INPUT_COMMAND.getMessage());
    }
}
