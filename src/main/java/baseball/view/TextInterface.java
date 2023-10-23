package baseball.view;

public class TextInterface {

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void isWaiting() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void success() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void nothing() {
        System.out.println("낫싱");
    }

    public void onlyStrike(int strike) {
        System.out.println(strike + "스트라이크");
    }

    public void onlyBall(int ball) {
        System.out.println(ball + "볼");
    }

    public void bothStrikeAndBall(int ball, int strike) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public void endGame() {
        System.out.println("게임 종료");
    }
}
