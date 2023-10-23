package baseball.application;

import baseball.domain.CheckMachine;
import baseball.domain.NumberGenerator;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.ArrayList;
import java.util.List;


public class BaseballGame {

    InputView inputView = new InputView();
    Player player = new Player(inputView);
    CheckMachine checkMachine = new CheckMachine();
    ResultView resultView = new ResultView();
    Referee referee = new Referee(resultView);
    NumberGenerator numberGenerator = new NumberGenerator();

    private List<Integer> generatedAnswer = new ArrayList<>();
    private List<Integer> pickNumbers = new ArrayList<>();
    boolean correct = false;

    public void play() {
        start();
        numberGenerator.generateAnswer();
        while(!player.isGameEnd()) {
            getInputNumber();
            getResult();
            askNextGame();
        }
    }
    public void start() {
        inputView.printStartGame();
        inputView.printAskInputNumber();
    }
    public void getInputNumber() {
        String[] input = inputView.inputNumber();
        pickNumbers = player.storeNumber(input);
    }
    public void getResult() {
        String result = checkMachine.checkAnswer(generatedAnswer, pickNumbers);
        resultView.showResult(result);
        correct = referee.isOut(result);
    }
    public void askNextGame() {
        if (correct) {
            inputView.printAskGameEnd();
            player.isGameEnd();
        }
    }
}
