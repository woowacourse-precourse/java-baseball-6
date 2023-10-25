package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    private Result result = new Result();
    private Validator validator = new Validator();
    private List<Character> randomNumbers;

    public void game() {
        start();
        play();
        end();
    }

    private void start() {
        System.out.println(GuideMessage.GAME_START);

        resetRandomNumbers();
    }

    private void play() {
        System.out.print(GuideMessage.INPUT_REQUEST);

        String userInput = Console.readLine();

        List<Character> userNumbers = Parsing.parseIntoList(userInput);

        result.calculate(userNumbers, randomNumbers);

        System.out.println(result.isResult());

        if (!result.isResult().equals("3스트라이크")) {
            play();
        }
    }

    private void end() {
        System.out.println(GuideMessage.GAME_EXIT);

        System.out.println(GuideMessage.RESTART_INPUT);

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
