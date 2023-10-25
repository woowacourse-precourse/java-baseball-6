package baseball.controller;

import baseball.dto.Score;
import baseball.entity.BaseballGameComputer;
import baseball.io.ConsoleInput;
import baseball.io.ConsoleOutput;

public class BaseballGame {

    private BaseballGameComputer baseballGameComputer;
    private Score score;

    public void run() {
        do {
            baseballGameComputer = new BaseballGameComputer();
            ConsoleOutput.printStart();

            while (true) {
                String answer = ConsoleInput.guessAnswer();

                score = baseballGameComputer.scoring(answer);

                ConsoleOutput.printResult(score);

                if (baseballGameComputer.isClear(score)) break;
            }
        } while(!ConsoleInput.askTermination());
        return;
    }
}
