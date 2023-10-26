package baseball;

public class ResultMapper {
    public static String getResult(int strike, int ball) {

        if (strike == 3 && ball == 3) {
            return "3스트라이크";
        }

        if (strike > 0 && ball > 0) {
            return String.format("%d볼 %d스트라이크", ball, strike);
        }

        if (strike > 0) {
            return String.format("%d스트라이크", strike);
        }
        if (ball > 0) {
            return String.format("%d볼", ball);
        }
        return "낫싱";
    }
 }
