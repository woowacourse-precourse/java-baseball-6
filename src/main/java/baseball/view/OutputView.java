package baseball.view;

public class OutputView {

    public void outputStrikeResult(int strike) {
        System.out.println(strike+"스트라이크");
    }

    public void outputNothing() {
        System.out.println("낫싱");
    }

    public void outputBallResult(int ball) {
        System.out.println(ball+"볼");
    }

    public void outputBallAndStrikeResult(int ball, int strike) {
        System.out.println(ball+"볼 "+strike+"스트라이크");
    }

    public void outputGameSuccess() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void outputRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void outputGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
