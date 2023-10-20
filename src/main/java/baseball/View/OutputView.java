package baseball.View;

import baseball.Model.GameData;

public class OutputView {

    private final GameData gameData;

    public OutputView(GameData gameData) {
        this.gameData = gameData;
    }
    public void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void printHint() {
        String hint = "";
        if (gameData.getBallCount() > 0) {
            hint += gameData.getBallCount() + "볼 ";
        }
        if (gameData.getStrikeCount() > 0) {
            hint += gameData.getStrikeCount() + "스트라이크";
        }
        if (hint.isEmpty()) {
            hint = "낫싱";
        }
        System.out.println(hint);
    }

}
