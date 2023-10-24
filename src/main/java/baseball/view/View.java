package baseball.view;

import baseball.Score;

public class View {

    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameResultMessage(Score score) {
        int strikeCount = score.getStrikeCount();
        int ballCount = score.getBallCount();

        if ((strikeCount == 0) && (ballCount == 0)) {
            System.out.println("낫싱");
            return;
        }

        if ((strikeCount > 0) && (ballCount > 0)) {
            System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
            return;
        }

        if (ballCount > 0) {
            System.out.printf("%d볼\n", ballCount);
            return;
        }

        if (strikeCount > 0) {
            System.out.printf("%d스트라이크\n", strikeCount);
        }
    }

    public void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printRestartCheckMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
