package baseball.view;

public class Console {
    public static String setUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    public static String setRegame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    public static void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printBallStrike(int[] ballStrikeCnt) {
        System.out.print(ballStrikeCnt[0] + "볼 ");
        System.out.println(ballStrikeCnt[1] + "스트라이크");
    }

    public static void printOnlyBall(int ball) {
        System.out.println(ball + "볼 ");
    }

    public static void printOnlyStrike(int strike) {
        System.out.println(strike + "스트라이크");
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printEnding() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
