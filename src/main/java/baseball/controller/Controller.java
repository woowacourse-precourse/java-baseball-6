package baseball.controller;

import baseball.domain.Game;
import baseball.domain.Judgement;
import baseball.domain.NumbersGenerator;
import baseball.infra.NumbersRandomGenerator;
import baseball.view.JudgementView;
import baseball.view.PredictView;
import baseball.view.RestartView;
import baseball.view.StartView;
import baseball.view.WinView;

public class Controller {

    private final NumbersGenerator numbersGenerator = new NumbersRandomGenerator();

    private final Game game = new Game(numbersGenerator);

    public void run() {
        StartView.print();
        do {
            playGame();
            RestartView.print();
        } while(RestartView.doRestart());
    }

    private void playGame() {
        game.initialize();
        Judgement judgement;
        do {
            final String input = PredictView.printAndRead();
            judgement = game.play(input);
            JudgementView.print(judgement);
        } while(!judgement.hasWon());
        WinView.print();
    }
}
