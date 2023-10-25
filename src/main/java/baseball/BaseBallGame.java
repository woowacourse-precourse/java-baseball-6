package baseball;

import static baseball.Computer.randomNum;
import static baseball.Player.userNum;
import static baseball.Validation.validateDigit;
import static baseball.Validation.validateDuplicateNumber;
import static baseball.Validation.validateNonNumeric;
import static baseball.Validation.validateRange;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseBallGame {

    public static String restartOrEnd() {

        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart = Console.readLine();
            if (!restart.equals("1") && !restart.equals("2")) {
                throw new IllegalArgumentException("재시작(1) 종료(2)입력해주세요.");

            }
            if (restart.equals("1")) {
                return "1";
            }
            if (restart.equals("2")) {
                return "2";
            }
        } while (true);
    }


    public static void oneGame() {
        List<Integer> com = randomNum();
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            List<Integer> user = userNum(input);

            validateRange(input);
            validateDuplicateNumber(input);
            validateDigit(input);
            validateNonNumeric(input);

            System.out.println(gameResult(com, user));
            if (countStrike(com, user) == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        } while (true);
    }

    public static int compareNum(List<Integer> com, List<Integer> player) {
        int result = 0;
        for (int i = 0; i < player.size(); i++) {
            if (com.contains(player.get(i))) {
                result += 1;
            }
        }
        return result;
    }

    public static int countStrike(List<Integer> com, List<Integer> player) {
        int strike = 0;
        for (int i = 0; i < player.size(); i++) {
            if (com.get(i) == player.get(i)) {
                strike += 1;
            }

        }
        return strike;
    }

    public static String gameResult(List<Integer> com, List<Integer> player) {
        int total = compareNum(com, player);
        int strike = countStrike(com, player);
        int ball = total - strike;

        if (total == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";

    }
}
