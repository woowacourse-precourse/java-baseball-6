package baseball;

public class Output {

    private static final int BALL_INDEX = 0;
    private static final int STRIKE_INDEX = 1;
    private static final int WIN_THE_GAME = 3;

    public void printResult(String gameResult) {
        int ballResult = Character.getNumericValue(gameResult.charAt(BALL_INDEX));
        int strikeResult = Character.getNumericValue(gameResult.charAt(STRIKE_INDEX));
        gameResultPrint(ballResult, strikeResult);
    }

    private void gameResultPrint(int ballResult, int strikeResult) {
        String gameResultForPrint = makeResultMessage(ballResult, strikeResult);
        System.out.println(gameResultForPrint);
        if (strikeResult == WIN_THE_GAME) {
            successThreeNumbers();
        }
    }

    private String makeResultMessage(int ballResult, int strikeResult) {
        String resultMessage = "";
        if (ballResult == 0 && strikeResult == 0) {
            resultMessage += "낫싱";
        }
        if (ballResult > 0) {
            resultMessage += ballResult + "볼";
        }
        if (ballResult > 0 && strikeResult > 0) {
            resultMessage += " ";
        }
        if (strikeResult > 0) {
            resultMessage += strikeResult + "스트라이크";
        }
        return resultMessage;
    }

    public void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputYourNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void retryOrQuitMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void endingMessage() {
        System.out.println("게임 종료");
    }

    private void successThreeNumbers() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
    }
}
