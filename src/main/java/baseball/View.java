package baseball;

public class View {

    public static void gameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printScore(int strike, int ball) {
        String result = "";
        if (strike == 0 && ball == 0) {
            result = "낫싱";
        }
        if (ball != 0) {
            result += ball + "볼 ";
        }
        if (strike != 0) {
            result += strike + "스트라이크";
        }
        System.out.println(result);
    }
}
