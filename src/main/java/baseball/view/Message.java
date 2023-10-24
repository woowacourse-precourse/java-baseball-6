package baseball.view;

public class Message {

    public static void gameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void inputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void threeStrikeMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void onlyStrikeMessage(int strike) {
        System.out.println(strike+"스트라이크");
    }

    public static void onlyBallMessage(int ball) {
        System.out.println(ball+"볼");
    }

    public static void ballWithStrikeMessage(int strike, int ball) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public static void noBallNoStrikeMessage() {
        System.out.println("낫싱");
    }

    public static void endGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
