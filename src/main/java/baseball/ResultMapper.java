package baseball;

public class ResultMapper {
    public static String getResult(int equalsNumber, int equalsPosition) {
        if (equalsNumber == 3 && equalsPosition == 3) {
            return "3스트라이크";
        }

        if (equalsNumber > 0 && equalsPosition > 0) {
            return String.format("%d스트라이크 %d볼", equalsNumber, equalsPosition);
        }

        if (equalsNumber > 0) {
            return String.format("%d스트라이크", equalsNumber);
        }
        if (equalsPosition > 0) {
            return String.format("%d볼", equalsPosition);
        }
        return "낫싱";
    }
 }
