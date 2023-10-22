package baseball;

import camp.nextstep.edu.missionutils.Console;

public class PitchResult {
    private int ball;
    private int strike;

    private int restartNumber;
    private RandomNumber randomNumber;

    private Validation validation;

    public PitchResult(RandomNumber randomNumber, Validation validation) {
        this.randomNumber = randomNumber;
        this.validation = validation;
    }

    public void addBall(int ball) {
        this.ball = ball + 1;
    }

    public void addStrike(int strike) {
        this.strike = strike + 1;
    }

    public void setRestartNumber(int restartNumber) {
        this.restartNumber = restartNumber;
    }

    public int getRestartNumber() {
        return restartNumber;
    }

    public void judgePitch(String inputString) {
        for (int i = 0; i < 3; i++) {
            if (randomNumber.getRandomNumber().get(i).equals(Character.getNumericValue(inputString.charAt(i)))) {
                addStrike(strike);
            } else if (randomNumber.getRandomNumber().contains(Character.getNumericValue(inputString.charAt(i)))) {
                addBall(ball);
            }
        }
    }

    public void printPitchResult() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하시면 2를 입력하세요.");
            setRestartNumber(Integer.parseInt(Console.readLine()));
            validation.restartValidation(restartNumber);
            if (restartNumber == 1) {
                randomNumber.randomNumberGenerate();
            }
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

}
