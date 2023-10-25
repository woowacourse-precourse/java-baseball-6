package baseball.view;

public class OutputView {

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public boolean showResult(int strikeNum, int ballNum) {
        if (strikeNum == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (strikeNum > 0 && ballNum > 0) {
            System.out.printf("%d볼 %d스트라이크%n", ballNum, strikeNum);
        } else if (strikeNum == 0 && ballNum > 0) {
            System.out.printf("%d볼%n", ballNum);
        } else if (strikeNum > 0 && ballNum == 0) {
            System.out.printf("%d스트라이크%n", strikeNum);
        } else {
            System.out.println("낫싱");
        }
        return false;
    }
}