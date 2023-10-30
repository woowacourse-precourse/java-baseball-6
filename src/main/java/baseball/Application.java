package baseball;

import baseball.domain.NumberGenerator;
import baseball.domain.Referee;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        NumberGenerator generator = new NumberGenerator();
        List<Integer> computer = generator.createRandomNumbers();

        Referee referee = new Referee();
        String result;
        while (true) {
            result = referee.compare(computer, askNumbers());
            System.out.println(result);
            if (result.equals("3스트라이크")) {
                boolean isReset = resetGame();
                if (isReset) {
                    computer = generator.createRandomNumbers();
                } else {
                    break;
                }
            }
        }


    }

    public static List<Integer> askNumbers() {
        System.out.print("숫자를 입력해 주세요: ");
        String input = Console.readLine();
        System.out.println(input);
        try {
            if (input.length() != 3) {
                throw new IllegalArgumentException("잘못된 입력으로 게임이 종료됩니다.");
            }
            List<Integer> numbers = new ArrayList<>();
            for (String number : input.split("")) {
                numbers.add(Integer.valueOf(number));
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력으로 게임이 종료됩니다.");
        }
    }

    public static boolean resetGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = Console.readLine();
        return answer.equals("1");
    }
}
