package baseball.view;

public class OutputView {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER = "숫자를 입력해 주세요 : ";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼 ";
    private static final String NOTHING = "낫싱";
    private static final String FINISH_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RETRY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void startGame() {
        System.out.println(START_GAME);
    }
    public void inputNumber() {
        System.out.print(INPUT_NUMBER);
    }
    public void strike(int strike, StringBuilder sb){
        sb.append(strike + STRIKE);
    }
    public void ball(int ball, StringBuilder sb) {
        sb.append(ball + BALL);
    }
    public void printBuilder(StringBuilder sb){
        System.out.println(sb);
    }
    public void nothing(StringBuilder sb) {
        sb.append(NOTHING);
    }
    public void finishGame() {
        System.out.println(FINISH_GAME);
    }
    public void retry() {
        System.out.println(RETRY);
    }

}
