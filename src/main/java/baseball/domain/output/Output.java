package baseball.domain.output;

public class Output {

    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String WAITING_NUMBER = "숫자를 입력해주세요 :";
    public static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_OR_NOT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String NUMBER_IS_NON_1_OR_2 = "1 혹은 2의 숫자가 아닙니다.";
    public static final String NO_CORRECT_NUMBER = "낫싱";
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";

    public void printStartGameMessage() {
        System.out.println(GAME_START);
    }

    public void printEndGameMessage() {
        System.out.println(GAME_END);
    }

    public void printRestartOrNotMessage() {
        System.out.println(RESTART_OR_NOT);
    }

    public void printNumberIsNoneMessage() {
        System.out.println(NUMBER_IS_NON_1_OR_2);
    }

    public void printGetNumberMessage() {
        System.out.print(WAITING_NUMBER);
    }

    public String printBallMessage(Integer ball) {
        if (ball != 0) {
            return ball + BALL + " ";
        }
        return "";
    }

    public String printStrikeMessage(Integer strike) {
        if (strike != 0) {
            return strike + STRIKE;
        }
        return "";
    }

    public void printAllStrikeMessage() {
        printEndGameMessage();
    }

    public String totalMessage(Integer ball, Integer strike) {
        String totalMessage = printBallMessage(ball) + printStrikeMessage(strike);
        if (totalMessage.equals("")) {
            return NO_CORRECT_NUMBER;
        }
        return totalMessage;
    }

    public void printTotalMessage(Integer ball, Integer strike) {
        System.out.println(totalMessage(ball, strike));
    }
}
