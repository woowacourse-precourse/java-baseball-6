package baseball;

public class Output {

    private static final String startMessage = "숫자 야구 게임을 시작합니다.";
    private static final String inputMessage = "숫자를 입력해주세요 : ";
    private static final String gameEndMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String gameRestartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public void printResult(int[] matchList) {
        if (matchList[MatchState.NOTHING.getValue()] > 0) {
            System.out.println(NOTHING);
        }
        else if (matchList[MatchState.BALL.getValue()] > 0 &&
                matchList[MatchState.STRIKE.getValue()] > 0) {
            System.out.println(matchList[0] + BALL + " " + matchList[1] + STRIKE);
        }
        else if (matchList[MatchState.BALL.getValue()] > 0) {
            System.out.println(matchList[0] + BALL);
        }
        else if (matchList[MatchState.STRIKE.getValue()] > 0) {
            System.out.println(matchList[1] + STRIKE);
        }
    }

    public void printStartMessage() {
        System.out.println(startMessage);
    }

    public void printInputMessage(String input) {
        System.out.print(inputMessage);
        System.out.println(input);
    }

    public void printGameEndMessage() {
        System.out.println(gameEndMessage);
        System.out.println(gameRestartMessage);
    }
}
