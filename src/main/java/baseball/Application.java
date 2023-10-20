package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 9, 3);

            int attempts = 0;
            while (attempts == 0) {
                System.out.print("숫자를 입력해주세요 : ");
                String inputNumber = Console.readLine();
                List<Integer> answer = parseInput(inputNumber);
                attempts = checkAnswer(randomNumber, answer);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            if (choice.equals("2")) {
                break;
            }
        }
    }



    private static List<Integer> parseInput(String input) {
        List<Integer> parse = new ArrayList<>();
        input.split("");

        validInputNumber(parse);

        return parse;
    }

    private static void validInputNumber(List<Integer> parseNumber) {
        if (parseNumber.size() > 3) {
            throw new IllegalArgumentException();
        }
    }

    private static int checkAnswer(List<Integer> randomNumber, List<Integer> answer) {

        return 1;
    }
}
