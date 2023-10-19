package baseball;

public class OutputView {
    public static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void printRequirePlayerInput() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public static void printBallAndStrikeResult(Integer strikeCnt, Integer ballCnt) {
        System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
    }

    public static void printBallOnlyResult(Integer ballCnt) {
        System.out.println(ballCnt + "볼 ");
    }

    public static void printStrikeOnlyResult(Integer strikeCnt) {
        System.out.println(strikeCnt + "스트라이크");
    }

    public static void printNothingResult() {
        System.out.println("낫싱");
    }

    public static void printEndgame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printAskRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
