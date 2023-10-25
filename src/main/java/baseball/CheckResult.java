package baseball;

public class CheckResult {

    CheckResult() {
    }

    public boolean isGuessCorrect(String userGuess, int targetIntValue) {
        String targetStringValue = intToStringWithLeadingZeros(targetIntValue, 3);

        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < targetStringValue.length(); i++) {
            for (int j = 0; j < userGuess.length(); j++) {
                if (i == j && targetStringValue.charAt(i) == userGuess.charAt(j)) {
                    strikeCount++;
                } else if (targetStringValue.charAt(i) == userGuess.charAt(j)) {
                    ballCount++;
                }
            }
        }

        if (ballCount != 0) {
            System.out.println(ballCount + "볼 ");
        }

        if (strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        }

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            return false;
        }

        if (strikeCount == 3) {
            return true;
        }

        return false;

    }

    public String intToStringWithLeadingZeros(int value, int length) {
        String intStr = Integer.toString(value);

        // 형식에 맞게 0을 추가
        while (intStr.length() < length) {
            intStr = "0" + intStr;
        }

        return intStr;
    }
}
