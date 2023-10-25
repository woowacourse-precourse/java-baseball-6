package baseball.controller;

public class Compare {
    private String hint = "";
    static int strikeCount;
    static int ballCount;

    public static int compareStrike(String computer, String user) {
        // 같은 자릿수, 같은 숫자
        strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.charAt(i) == user.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public static int compareBall(String computer, String user) {
        // 다른 자릿수, 같은 숫자
        ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if ((computer.contains(String.valueOf(user.charAt(i)))
                    && (computer.charAt(i) != user.charAt(i)))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public static String hintMessage() {
        // 비교 결과
        String hint = "";
        if (ballCount > 0) {
            hint += ballCount + "볼";
        }
        if (strikeCount > 0) {
            if (!hint.isEmpty()) {
                hint += " ";
            }
            hint += strikeCount + "스트라이크";
        }
        if (strikeCount == 0 && ballCount == 0) {
            hint = "낫싱";
        }
        return hint;
    }
}