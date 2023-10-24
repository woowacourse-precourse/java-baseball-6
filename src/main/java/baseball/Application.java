package baseball;

import baseball.util.Util;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final List<Integer> computer = Util.makeRandomNumbers();

        String input;
        System.out.println("숫자 야구 게임을 시작합니다.");

        outer:
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            input = Console.readLine();
            List<Integer> inputNumbers = Util.toIntegerArray(input);
            String comment = takeTurn(computer, inputNumbers);

            break outer;
        }
    }

    private static String takeTurn(List<Integer> computer, List<Integer> inputNumbers) {
        String comment = "";
        comment += countBall(computer, inputNumbers);
        comment += countStrike(computer, inputNumbers);

        return comment;
    }

    private static String countStrike(List<Integer> computer, List<Integer> inputNumbers) {
        return null;
    }

    private static String countBall(List<Integer> computer, List<Integer> inputNumbers) {
        return null;
    }

}
