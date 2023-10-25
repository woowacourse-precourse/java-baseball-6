package baseball;

public class Judge {
    public static String judge(int[] answer, int[] input) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (answer[i] == input[i]) {
                strikes++;
            } else if (containsDigit(answer, input[i])) {
                balls++;
            }
        }

        if (strikes == 3) {
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }

        String result = "";
        if (balls > 0) {
            result += balls + "볼";
        }

        if (strikes > 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += strikes + "스트라이크";
        }

        return result.isEmpty() ? "낫싱" : result;
    }

    private static boolean containsDigit(int[] arr, int digit) {
        for (int num : arr) {
            if (num == digit) {
                return true;
            }
        }
        return false;
    }
}
