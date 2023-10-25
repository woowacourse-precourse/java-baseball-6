package baseball;

/**
 * 게임에 필요한 메시지 출력을 담당 하는 클래스 이다.
 */
public class OutputHandler {
    private static final int ZERO = 0;

    private static void println(String message) {
        System.out.println(message);
    }

    private static String getBlankChar(String message) {
        if(!message.isEmpty()) {
            return " ";
        }

        return "";
    }

    private static boolean hasCount(int count) {
        if(count > ZERO) {
            return true;
        }

        return false;
    }

    private static boolean hasNotCount(int[] counts) {
        for(int cnt : counts) {
            if(cnt != ZERO) {
                return false;
            }
        }

        return true;
    }

    public static void showGameStartMessage() {
        println("숫자 야구 게임을 시작합니다.");
    }

    public static void showGamePromptNumbersMessage() {
        println("숫자를 입력해주세요 : ");
    }

    public static void showNumberCheckResultMessage(int ballCnt, int strikeCnt) {
        String resultMessage = "";

        if(hasCount(ballCnt)) {
            resultMessage += ballCnt + "볼";
        }

        if(hasCount(strikeCnt)) {
            resultMessage += getBlankChar(resultMessage);
            resultMessage += strikeCnt + "스트라이크";
        }

        if(hasNotCount(new int[]{ballCnt, strikeCnt})) {
            resultMessage += "낫싱";
        }

        println(resultMessage);
    }

    public static void showGameEndMessage() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void showRestartPrompt() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
