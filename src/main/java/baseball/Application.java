package baseball;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            Game game = new Game();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = readLine();
                List<Integer> number = convertIntegerList(input);
                validateThreeNums(number);
                validateUnduplicated(number);

                boolean isAnswer = game.play(number);
                if (isAnswer) break;
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = readLine();

            if (input.equals("1")) {
                continue;
            }
            if (input.equals("2")) {
                break;
            }
        }
    }

    private static List<Integer> convertIntegerList(String number) {
        try {
            return Arrays.stream(number.split(""))
                    .map(Integer::parseInt)
                    .filter(n -> n != 0)
                    .toList();
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자가 아닌 숫자를 입력해주세요");
        }
    }

    private static void validateThreeNums(List<Integer> number) {
        if (number.size() != 3) {
            throw new IllegalArgumentException("1부터 9까지 3개의 숫자를 입력해주세요");
        }
    }

    private static void validateUnduplicated(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("서로 다른 숫자들을 입력해주세요");
        }
    }

}
