package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Validator validator = new Validator();

        System.out.println("숫자 야구 게임을 시작합니다.");

        System.out.print("숫자를 입력해주세요 : ");

        String userInput = Console.readLine();

        try {
            validator.validate(userInput);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        List<Character> userNumbers = Parsing.parseIntoList(userInput);

        List<Character> randomNumbers = RandomMaker.makeRandomNumbers();

        Result result = new Result();

        result.calculate(userNumbers, randomNumbers);

        System.out.println(result.isResult());
    }
}
