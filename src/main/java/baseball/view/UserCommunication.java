package baseball.view;

import baseball.domain.GuessResult;
import camp.nextstep.edu.missionutils.Console;

import static baseball.constant.GameConstant.SUCCESS_STRIKE_COUNT;

public class UserCommunication {

    public static final String RESTART_CODE = "1";
    public static final String EXIT_CODE = "2";

    public static String askForNumber() {
        System.out.print("숫자를 입력하세요: ");
        return Console.readLine();
    }

    public static void printWinningMessage() {
        System.out.println(SUCCESS_STRIKE_COUNT + "스트라이크");
        System.out.println(SUCCESS_STRIKE_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static boolean shouldExit() {
        System.out.print(String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요: ", RESTART_CODE, EXIT_CODE));
        String choice = Console.readLine();

        if (RESTART_CODE.equals(choice)) {
            return false;
        }
        if (EXIT_CODE.equals(choice)) {
            return true;
        }

        throw new IllegalArgumentException(String.format("%s와 %s 두 번호 중 중 하나가 입력되어야 합니다.", RESTART_CODE, EXIT_CODE));
    }

    public static void printGameStatus(GuessResult guessResult) {
        int strikeCount = guessResult.getStrikeCount();
        int ballCount = guessResult.getBallCount();

        String statusMessage = getStatusMessage(ballCount, strikeCount);
        System.out.println(statusMessage);
    }

    private static String getStatusMessage(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }
        if (ballCount != 0 && strikeCount == 0) {
            return ballCount + "볼";
        }
        if (ballCount == 0 && strikeCount != 0) {
            return strikeCount + "스트라이크";
        }
        return ballCount + "볼 " + strikeCount + "스트라이크";
    }
}
