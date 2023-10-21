package baseball;

public class BaseballView {

    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    public void outputStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void outputPlayMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void outputHintResultMessage(HintResult hintResult) {
        if (hintResult.isNothing()) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }

        StringBuilder hintResultMessage = new StringBuilder();
        int ball = hintResult.getBall();
        int strike = hintResult.getStrike();
        if (ball != 0) {
            hintResultMessage.append(ball).append(BALL_MESSAGE).append(" ");
        }
        if (strike != 0) {
            hintResultMessage.append(strike).append(STRIKE_MESSAGE);
        }
        System.out.println(hintResultMessage);
    }

    public void outputFinishMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
