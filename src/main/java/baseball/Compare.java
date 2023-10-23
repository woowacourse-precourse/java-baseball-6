package baseball;

import java.util.List;
import static baseball.ComputerNumber.randomNumber;
import static baseball.UserInput.validatedUserInput;

public class Compare {
    public static void CompareNumbers() {
        List<Integer> computerNumbers = randomNumber();
        while (true) {
            List<Integer> userNumbers = validatedUserInput();
            int strikes = 0;
            int balls = 0;

            for (int i = 0; i < 3; i++) {
                if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                    strikes++;
                } else if (computerNumbers.contains(userNumbers.get(i))) {
                    balls++;
                }
            }
            if (strikes == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            if (strikes > 0 || balls > 0) {
                System.out.println( balls + "볼 " + strikes + "스트라이크");
            }
            if (strikes == 0 && balls == 0) {
                System.out.println("낫싱");
            }
        }
    }
}
