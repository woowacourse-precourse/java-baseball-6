package baseball;

import baseball.domain.BaseballNumbers;
import baseball.generator.RandomNumberGenerator;

public class Application {


    public static void main(String[] args) {
        View view = new View();
        play(view);
    }

    private static void play(View view) {
        GameStatus gameStatus = GameStatus.CONTINUE;
        while (gameStatus != GameStatus.END) {
            BaseballNumbers answerNumbers = new BaseballNumbers(new RandomNumberGenerator());
            playRound(view, answerNumbers);
            gameStatus = view.askRestartOrEnd();
        }
    }

    private static void playRound(View view, BaseballNumbers answerNumbers) {
        boolean isCorrect = false;
        while (!isCorrect) {
            BaseballNumbers guessNumbers = new BaseballNumbers(view.askGuess());
            GuessResult guessResult = answerNumbers.guess(guessNumbers);
            view.showGuessResult(guessResult.strikeCount(), guessResult.ballCount());
            isCorrect = guessResult.isCorrect();
        }
    }
}
