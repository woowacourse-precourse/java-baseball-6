package baseball;

/**
 * 게임에 필요한 메시지 출력을 담당 하는 클래스 이다.
 */
public class OutputHandler {
    public static void showGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void showGamePromptNumbersMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public static void showNumberCheckResultMessage(int ballCnt, int strikeCnt) {
        String resultMessage = "";
        if(ballCnt > 0) {
            resultMessage += ballCnt + "볼";
        }

        if(strikeCnt > 0) {
            if(!resultMessage.isEmpty()) {
                resultMessage += " ";
            }

            resultMessage += strikeCnt + "스트라이크";
        }

        if(ballCnt == 0 && strikeCnt == 0) {
            resultMessage += "낫싱";
        }

        System.out.println(resultMessage);
    }

    public static void showGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void showRestartPrompt() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
