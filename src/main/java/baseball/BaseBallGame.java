package baseball;

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

            applyResult(guessResult);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private String getUserGuess() {
        System.out.print("숫자를 입력해주세요 : ");

        return Console.readLine();
    }

    private void applyResult(GuessResult guessResult) {
        endFlag = guessResult.isCorrect();

        System.out.println(guessResult.message());
    }
}
