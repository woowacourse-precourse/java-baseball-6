package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {

    private int baseballNumber;
    private final RandomNumberProvider randomNumberProvider;

    public BaseballGame(RandomNumberProvider randomNumberProvider) {
        this.randomNumberProvider = randomNumberProvider;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String isReplay = "1";
        while(isReplay.equals("1")) {
            baseballNumber = randomNumberProvider.getRandomNumber();
            int inputNumber = input();
            while (!isCorrect(inputNumber)) {
                System.out.println(getResult(String.valueOf(inputNumber)));
                inputNumber = input();
            }
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isReplay = Console.readLine();
            if (!isReplay.equals("1") && !isReplay.equals("2")) {
                throw new IllegalArgumentException();
            }
        }
    }

    private int input() {
        System.out.print("숫자를 입력해주세요 : ");
        try {
            String input = Console.readLine();
            isValidBaseballNum(input);
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void isValidBaseballNum(String input) throws IllegalArgumentException {
        if(input.length() != 3) {
            throw new IllegalArgumentException();
        }

        if (input.charAt(0) == '0' || input.charAt(1) == '0' || input.charAt(2) == '0') {
            throw new IllegalArgumentException();
        }
        // 문제에 따르면 모든 자릿수의 숫자가 달라야 하기 때문에 같은 숫자가 있을 경우 제외
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }

    private String getResult(String input) {
        int strike = getStrike(input);
        int ball = getBall(input) - strike;

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        return ball + "볼" + " " + strike + "스트라이크";
    }

    private int getStrike(String input) {
        String baseballNumberStr = String.valueOf(baseballNumber);
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) == baseballNumberStr.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int getBall(String input) {
        String baseballNumberStr = String.valueOf(baseballNumber);
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (baseballNumberStr.contains(String.valueOf(input.charAt(i)))) {
                ball++;
            }
        }
        return ball;
    }

    private boolean isCorrect(int inputNum) {
        return baseballNumber == inputNum;
    }
}
