package baseball.view;

public class OutputView {
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printHint(int ballCount, int strikeCount) {
        String hint = "";
        if (ballCount > 0)
            hint += ballCount + "볼 ";
        if (strikeCount > 0)
            hint += strikeCount + "스트라이크";
        if (hint.length() == 0)
            System.out.print("낫싱");

        System.out.println(hint);
    }

    public void printWin() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
