package baseball;

public class View {

    public static void printStartGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printNumberInsertMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printNothingMessage() {
        System.out.println("낫싱");
    }

    public static void printBallAndStrikeMessage(int ball, int strike) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}
