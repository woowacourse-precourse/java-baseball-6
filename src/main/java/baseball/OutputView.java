package baseball;

public class OutputView {

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printRequirePlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printBallAndStrikeResult(int strikeCount, int ballCount) {
        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }

    public void printBallOnlyResult(int ballCount) {
        System.out.println(ballCount + "볼");
    }

    public void printStrikeOnlyResult(int strikeCount) {
        System.out.println(strikeCount + "스트라이크");
    }

    public void printNothingResult() {
        System.out.println("낫싱");
    }

    public void printEndgame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printAskRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printInvalidInput() {
        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
    }
}