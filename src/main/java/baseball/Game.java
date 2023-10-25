package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    private final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    private final String GAME_EXIT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String RESTART_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private Result result = new Result();
    private Validator validator = new Validator();
    private List<Character> randomNumbers;

    public void game() {
        start();
        play();
        end();
    }

    private void start() {
        System.out.println(GAME_START_MESSAGE);

        resetRandomNumbers();
    }

    private void play() {
        System.out.print(INPUT_REQUEST_MESSAGE);

        String userInput = Console.readLine();

        validator.validateNumberInput(userInput);

        List<Character> userNumbers = Parsing.parseIntoList(userInput);

        result.calculate(userNumbers, randomNumbers);

        System.out.println(result.isResult());

        if (!result.isResult().equals("3스트라이크")) {
            play();
        }
    }

    private void end() {
        System.out.println(GAME_EXIT_MESSAGE);

        System.out.println(RESTART_INPUT_MESSAGE);

        String restartInput = Console.readLine();

        validator.validateRestartInput(restartInput);

        if (restartInput.equals("1")) {
            game();
        }
    }

    private void resetRandomNumbers() {
        randomNumbers = RandomMaker.makeRandomNumbers();
    }
}
