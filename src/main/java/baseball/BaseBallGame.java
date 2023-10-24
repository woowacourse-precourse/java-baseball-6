package baseball;

import static java.text.MessageFormat.format;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    private static final int NUMBER_LENGTH = 3;

    private final Opponent opponent;

    private boolean endFlag;

    public BaseBallGame() {
        opponent = new Opponent(NUMBER_LENGTH);
        endFlag = false;
    }

    public void start() {
        while (!endFlag) {
            String userGuess = getUserGuess();
            GuessResult guessResult = opponent.guess(userGuess);
            String message = resolveResult(guessResult);

            System.out.println(message);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private String getUserGuess() {
        System.out.print("숫자를 입력해주세요 : ");

        return Console.readLine();
    }

    private String resolveResult(GuessResult guessResult) {
        int ball = guessResult.ball();
        int strike = guessResult.strike();

        endFlag = strike == NUMBER_LENGTH;

        if (strike == 0) {
            return format("{0}볼", ball);
        }

        if (ball == 0) {
            return format("{0}스트라이크", strike);
        }

        return format("{0}볼 {1}스트라이크", ball, strike);
    }
}
