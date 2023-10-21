package baseball;

public class Game {

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
        int strike = 0;
        int ball = 0;
        String computerNumber = "123";
        for (int i = 0; i < 3; i++) {
            if (userNumber.contains(String.valueOf(computerNumber.charAt(i)))) {
                ball++;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (userNumber.charAt(i) == computerNumber.charAt(i)) {
                strike++;
                ball--;
            }
        }

        return generateOutput(strike, ball);
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
