package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame implements Game {
    private final String number;
    private final int numberLength;
    private final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public BaseballGame() {
        this.numberLength = 3;
        this.number = createNumber(numberLength);
    }

    private String createNumber(int numberLength) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < numberLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int number : computer) {
            stringBuilder.append(number);
        }
        return stringBuilder.toString();
    }

    public void play() {
        Result result;
        do {
            System.out.print(USER_INPUT_MESSAGE);
            String userInput = Console.readLine();
            validateUserInput(userInput);
            result = judge(userInput);
            System.out.println(result);
        } while (!isAllStrike(result));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean isAllStrike(Result result) {
        return result.getStrike() == numberLength;
    }

    private Result judge(String userInput) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < numberLength; i++) {
            char userNumber = userInput.charAt(i);
            if (userNumber == number.charAt(i)) {
                strike++;
            } else if (number.contains(String.valueOf(userNumber))) {
                ball++;
            }
        }
        return new Result(strike, ball);
    }

    private void validateUserInput(String userInput) {
        if (userInput.length() != numberLength) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
        for (char number : userInput.toCharArray()) {
            if (number < '1' || number > '9') {
                throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해주세요.");
            }
        }
        long distinctCount = userInput.chars().distinct().count();
        if (distinctCount != numberLength) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
        }
    }

    static class Result {
        private int strike;
        private int ball;

        public Result(int strike, int ball) {
            this.strike = strike;
            this.ball = ball;
        }

        public int getStrike() {
            return strike;
        }

        @Override
        public String toString() {
            if (ball > 0 && strike > 0) {
                return ball + "볼 " + strike + "스트라이크";
            } else if (ball > 0) {
                return ball + "볼";
            } else if (strike > 0) {
                return strike + "스트라이크";
            } else {
                return "낫싱";
            }
        }
    }
}
