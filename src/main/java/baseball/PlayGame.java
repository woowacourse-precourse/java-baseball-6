package baseball;

import baseball.logic.Logic;
import baseball.view.ViewInput;
import baseball.view.ViewOutput;

public class PlayGame {
    private static ViewInput viewInput = new ViewInput();
    private static ViewOutput viewOutput = new ViewOutput();

    private Opponent opponent = new Opponent();
    private Logic logic = new Logic();

    public void play() {
        int[] correctAnswers = opponent.makeRandomNumber();
        int strikeCount = 0;

        while(strikeCount != 3) {
            int inputAnswer = viewInput.getAnswer();
            int[] scores = logic.scoringResult(inputAnswer, correctAnswers);
            strikeCount = scores[0];
            viewOutput.printScore(scores);
        }
    }
}
