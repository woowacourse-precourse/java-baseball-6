package baseball;

public class GameResultMessage {
    public static String generateResultMessage(int[] result) {
        /*
         * 스트라이크, 볼 여부 출력
         */
        String message = "";
        if (result[0] == 0 && result[1] == 0) {
            message = "낫싱";
        }
        if (result[1] == 3) {
            message = "3스트라이크";
        }
        if (result[0] > 0) {
            message += result[0] + "볼 ";
        }
        if (result[1] > 0 && result[1] != 3) {
            message += result[1] + "스트라이크";
        }

        return message;
    }
}

