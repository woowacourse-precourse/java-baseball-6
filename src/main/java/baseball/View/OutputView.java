package baseball.View;

public class OutputView {

    public void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void printHint(int ballCount, int strikeCount) {
        String hint = "";
        if (ballCount > 0) {
            hint += ballCount + "볼 ";
        }
        if (strikeCount > 0) {
            hint += strikeCount + "스트라이크";
        }
        if (hint.isEmpty()) {
            hint = "낫싱";
        }
        System.out.println(hint);
    }

}
