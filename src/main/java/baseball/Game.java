package baseball;

import static baseball.GuideMessage.GAME_EXIT_MESSAGE;
import static baseball.GuideMessage.GAME_START_MESSAGE;
import static baseball.GuideMessage.INPUT_REQUEST_MESSAGE;
import static baseball.GuideMessage.RESTART_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {

    //의존성 주입 여기다 하지말고 인터페이스로 구현해서 다른 곳에서 호출하도록
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

        List<Character> userNumbers = Parser.parseIntoList(userInput);

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
