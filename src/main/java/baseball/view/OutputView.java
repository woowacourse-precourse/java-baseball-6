package baseball.view;

import baseball.domain.GameStatus;

public class OutputView {

    public OutputView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameResult(GameStatus gamestatus) {
        String result = "";
        if (gamestatus.getBallCnt() != 0) {
            result += gamestatus.getBallCnt() + "볼";
        }
        if (gamestatus.getStrikeCnt() != 0) {
            result += gamestatus.getStrikeCnt() + "스트라이크";
        }
        if (gamestatus.getStrikeCnt() == 0 && gamestatus.getBallCnt() == 0) {
            result += "낫싱";
        }
        System.out.println(result);
    }

    public void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
