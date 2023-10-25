package baseball.controller;

import baseball.model.ComputerGenerator;
import baseball.model.ScoreBoard;
import baseball.model.TurnBasedPlay;
import baseball.util.GameConstant;
import baseball.view.AppView;


public class AppController {
    public int _command;
    public int _inputNumber;
    public int _ball;
    public int _strike;
    public int[] computer;

    public AppController () {
        this._command = 1;
        this._ball = 0;
        this._strike = 0;
    }

    private void PlayGame () {
        while (checkFinish()) {
            computer = ComputerGenerator.computerList();
            initVariable();

            turnPlay();

            AppView.outputSuccess();

            _command = AppView.inputCommand();
        }
    }

    private void turnPlay () {
        while (!checkSuccess()) {
            _inputNumber = AppView.inputNumber();

            ScoreBoard score = TurnBasedPlay.CalculScore(computer, _inputNumber);

            _ball = score.ball;

            _strike = score.strike;

            showScore();
        }
    }

    private void showScore () {
        AppView.outputState(_ball, _strike);
    }
    private boolean checkSuccess () {
        return _strike == 3;
    }
    private boolean checkFinish () {
        return _command == 1;
    }
    private void initVariable () {
        _ball = 0;
        _strike = 0;
    }

    public void run () {
        AppView.outputStart();

        PlayGame();
    }
}
