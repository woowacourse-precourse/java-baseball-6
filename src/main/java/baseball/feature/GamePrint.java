package baseball.feature;

public class GamePrint {

    public void printGameResult(int strike, int ball) {
        System.out.println(printHint(strike, ball));
    }

    public String printHint(int strike, int ball) {
        String result = "";
        if (ball != 0) {
            result += ball + "볼 ";
        }
        if (strike != 0) {
            result += strike + "스트라이크 ";
        }
        if (result.isEmpty()) {
            result = "낫싱";
        }
        return result;
    }

}
