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
        System.out.println("숫자 야구 게임을 시작합니다.");

        resetRandomNumbers();
    }

    private void play() {
        System.out.print("숫자를 입력해주세요 : ");

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
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

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
