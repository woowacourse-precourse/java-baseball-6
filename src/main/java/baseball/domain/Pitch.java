package baseball.domain;

import static baseball.domain.utils.InputRange.MAX_INPUT_RANGE;
import static baseball.domain.utils.InputRange.MIN_INPUT_RANGE;

import baseball.utils.RandomNumbers;
import java.util.stream.IntStream;

public class Pitch {
    private int ball;
    private int strike;
    private final RandomNumbers randomNumber;

    public static final int MAX_STRIKE = 3;

    private static final int MIN_BALL = 0;
    private static final int MIN_STRIKE = 0;
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String STRIKE = "%d스트라이크";
    private static final String BALL = "%d볼";
    private static final String STRIKE_AND_BALL = "%d볼 %d스트라이크";
    private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하시면 2를 입력하세요.";


    public Pitch(RandomNumbers randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    private void addBall() {
        ball++;
    }

    private void addStrike() {
        strike++;
    }


    public void pitchClear() {
        this.ball = MIN_BALL;
        this.strike = MIN_STRIKE;
    }

    private boolean checkStrike(int index, int digit) {
        if (randomNumber.getDigit(index) == digit) {
            return true;
        }
        return false;
    }

    private boolean checkBall(int digit) {
        if (randomNumber.getRandomNumbers().contains(digit)) {
            return true;
        }
        return false;
    }

    public int toInteger(String inputNumbers, int index) {
        return Character.getNumericValue(inputNumbers.charAt(index));
    }

    public void judgePitch(String inputNumbers) {
        IntStream.range(MIN_INPUT_RANGE.getValue(), MAX_INPUT_RANGE.getValue())
                .forEach(index -> {
                    int currentNumber = toInteger(inputNumbers, index);
                    addStrikeAndBall(currentNumber, index);
                });
    }

    private void addStrikeAndBall(int number, int index) {
        if (checkStrike(index, number)) {
            addStrike();
        } else if (checkBall(number)) {
            addBall();
        }
    }

    public void printPitchResult() {
        if (strike == MIN_STRIKE && ball == MIN_BALL) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }

        if (strike == MAX_STRIKE) {
            System.out.println(String.format(STRIKE, strike));
            System.out.println(END_GAME_MESSAGE);
            System.out.println(RESTART_MESSAGE);
            return;
        }

        if (strike == MIN_STRIKE) {
            System.out.println(String.format(BALL, ball));
            return;
        }

        if (ball == MIN_BALL) {
            System.out.println(String.format(STRIKE, strike));
            return;
        }

        System.out.println(String.format(STRIKE_AND_BALL, ball, strike));
    }

}
