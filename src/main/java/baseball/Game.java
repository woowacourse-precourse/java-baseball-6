package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    private Result result = new Result();
    private Validator validator = new Validator();

    public void game() {
        start();
        play();
        end();
    }

    private void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void play() {
        System.out.print("숫자를 입력해주세요 : ");

        String userInput = Console.readLine();

        validator.validate(userInput);

        List<Character> userNumbers = Parsing.parseIntoList(userInput);

        List<Character> randomNumbers = RandomMaker.makeRandomNumbers();

        result.calculate(userNumbers, randomNumbers);

        System.out.println(result.isResult());
    }

    private void end() {

    }
}
