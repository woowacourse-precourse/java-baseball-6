package baseball;

public class BaseballGameView {

    public void print(BaseballGameModel model) {
        int[] ballCount = model.getBallCount();
        int strike = ballCount[0];
        int ball = ballCount[1];
        int size = model.getSize();

        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }

        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }

        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }

        System.out.println();

        if (strike == size) {
            System.out.print("정답입니다! 새 게임을 시작하려면 1, 게임을 종료하려면 2를 입력하세요.");
        }
    }
}
