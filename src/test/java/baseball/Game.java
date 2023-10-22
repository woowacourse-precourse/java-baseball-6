package baseball;

public class Game {

    public String start(String userNumber) {
        String result = compareNumber(userNumber);
        if (result.equals("3스트라이크")) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        return "";
    }

    public String validateUserNumber(String userNumber) {
        if (isNumber(userNumber)) {
            throw new IllegalArgumentException("숫자가 아니다");
        }
        if (isDuplicateNumber(userNumber)) {
            throw new IllegalArgumentException("중복 숫자가 존재한다");
        }
        return userNumber;
    }

    private boolean isNumber(String userNumber) {
        return !userNumber.matches("[0-9]+");
    }

    private boolean isDuplicateNumber(String userNumber) {
        return userNumber.charAt(0) == userNumber.charAt(1) ||
                userNumber.charAt(0) == userNumber.charAt(2) ||
                userNumber.charAt(1) == userNumber.charAt(2);
    }

    public String compareNumber(String userNumber) {
        // String computerNumber = new Computer().generateRandomNumber();
        String computerNumber = "123";
        int ball = calculateBallCount(userNumber, computerNumber);
        int strike = calculateStrikeCount(userNumber, computerNumber);
        ball -= strike;

        return generateOutput(strike, ball);
    }

    private int calculateStrikeCount(String userNumber, String computerNumber) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumber.charAt(i) == computerNumber.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int calculateBallCount(String userNumber, String computerNumber) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumber.contains(String.valueOf(computerNumber.charAt(i)))) {
                ball++;
            }
        }
        return ball;
    }

    private String generateOutput(int strike, int ball) {
        String result = "";
        if (strike == 0 && ball == 0) {
            result = "낫싱";
        } else if (strike == 0) {
            result = ball + "볼";
        } else if (ball == 0) {
            result = strike + "스트라이크";
        } else {
            result = ball + "볼 " + strike + "스트라이크";
        }
        return result;
    }
}
