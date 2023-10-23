package baseball.print;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class OutputMessage {
    private static final String ENTER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String PRINT_MESSAGE_START_BASEBALLGAME = "숫자 야구 게임을 시작합니다.";

    public static void printMessageStartBaseballGame() {
        System.out.println(PRINT_MESSAGE_START_BASEBALLGAME);
    }

    public static void printEnterNumber() {
        System.out.print(ENTER_NUMBER);
    }

    public static void outputStrikeBallConsoleMessage(Integer strikes, Integer balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println(NOTHING);
            return;
        }

        StringBuilder result = new StringBuilder();

        if (balls > 0) {
            result.append(balls).append(BALL);
        }
        if (strikes > 0) {
            result.append(strikes).append(STRIKE);
        }

        System.out.println(result.toString());
    }

    public static Integer getGameStatusInput() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String endInputMessage = readLine();

        return (endInputMessage != null) ? Integer.valueOf(endInputMessage) : 0;
    }
}
