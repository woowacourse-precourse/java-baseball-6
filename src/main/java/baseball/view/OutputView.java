package baseball.view;

import baseball.domain.Player;

public class OutputView {

    public void printGameStartView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printHintView(Player player) {
        int ballCount = player.getBallCount();
        int strikeCount = player.getStrikeCount();

        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }

        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크");
        }

        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public void printGameEndView() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
