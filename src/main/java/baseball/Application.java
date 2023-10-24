package baseball;

import baseball.domain.Baseball;
import baseball.service.BaseballService;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static baseball.util.GameVariables.*;

public class Application {
    public static void main(String[] args) {
        BaseballService baseballService = new BaseballService();
        Baseball baseball = new Baseball(getNumber());
        System.out.println(getStartSentence());

        while (true) {
            System.out.print(getInputSentence());
            String inputStr = Console.readLine();

            if (!checkValidationInputStrPattern(inputStr)) {
                throw new IllegalArgumentException(getErrorMessage());
            }

            int input = Integer.parseInt(inputStr);

            // 정답
            if (baseballService.checkEquals(baseball, input)) {
                System.out.println(getEndSentence());
                int inputForRestart = Integer.parseInt(Console.readLine());
                if (inputForRestart == 1) {
                    baseball.setNumber(getNumber());
                    continue;
                }
                else if (inputForRestart == 2) break;
            }

            // 낫싱
            if (baseballService.checkNothing(baseball, input)) {
                System.out.println(getNothing());
                continue;
            }

            // 스트라이크 & 볼
            StringBuilder stringBuilder = new StringBuilder();
            List<Integer> resultByBallAndStrike = baseballService.getBallAndStrikeNumber(baseball, input);
            int ballNumber = resultByBallAndStrike.get(0);
            int strikeNumber = resultByBallAndStrike.get(1);

            if (ballNumber != 0) {
                stringBuilder.append(ballNumber).append(getBall()).append(" ");
            }

            if (strikeNumber != 0) {
                stringBuilder.append(strikeNumber).append(getStrike());
            }

            System.out.println(stringBuilder.toString());
        }
    }

    private static int getNumber() {
        int digit1, digit2, digit3;
        do {
            digit1 = Randoms.pickNumberInRange(1, 9);
            digit2 = Randoms.pickNumberInRange(1, 9);
            digit3 = Randoms.pickNumberInRange(1, 9);
        } while (digit1 == digit2 || digit1 == digit3 || digit2 == digit3);

        return digit1 * 100 + digit2 * 10 + digit3;
    }

    private static boolean checkValidationInputStrPattern(String inputStr) {
        String inputPattern = getNumberPattern();
        Pattern pattern = Pattern.compile(inputPattern);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }
}
