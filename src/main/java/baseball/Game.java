package baseball;

public class Game {

    public String start() {
        String result = "";
        String computerNumber = new Computer().generateRandomNumber();
        //String computerNumber = "123";
        while (!result.equals("3스트라이크")) {
            System.out.println("숫자를 입력해주세요 : ");
            String userNumber = new Input().get();
            validateUserNumber(userNumber);
            result = compareNumber(userNumber, computerNumber);
            new Output().print(result);
        }
        return result;
    }

    public boolean restart() {
        new Output().print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return new Input().get().equals("1");
    }

    public String validateUserNumber(String userNumber) {
        if (isNumber(userNumber)) {
            throw new IllegalArgumentException("숫자가 아니다");
        }
        if (is3Digit(userNumber)) {
            throw new IllegalArgumentException("3자리의 숫자가 아니다");
        }
        if (isDuplicateNumber(userNumber)) {
            throw new IllegalArgumentException("중복 숫자가 존재한다");
        }
        return userNumber;
    }

    private boolean isNumber(String userNumber) {
        return !userNumber.matches("[0-9]+");
    }

    private boolean is3Digit(String userNumber) {
        return userNumber.length() != 3;
    }

    private boolean isDuplicateNumber(String userNumber) {
        return userNumber.charAt(0) == userNumber.charAt(1) ||
                userNumber.charAt(0) == userNumber.charAt(2) ||
                userNumber.charAt(1) == userNumber.charAt(2);
    }

    public String compareNumber(String userNumber, String computerNumber) {
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
