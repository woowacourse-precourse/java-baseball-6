package baseball.application;

import baseball.domain.*;
import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.ArrayList;
import java.util.List;


public class BaseballGame {

//    InputView inputView = new InputView();
//    Player player = new Player();
//    CheckMachine checkMachine = new CheckMachine();
//    ResultView resultView = new ResultView();
//    Referee referee = new Referee();
//    NumberGenerator numberGenerator = new NumberGenerator();
//    private List<Integer> generatedAnswer = new ArrayList<>();
//    private List<Integer> pickNumbers = new ArrayList<>();
//    String[] input;
//    boolean correct = false;
    boolean gameContinue = false;

    public void play() {
        InputView inputView = new InputView();
        inputView.printStartGameMessage();
        List<Integer> answers = NumberGenerator.generateAnswer();

        while(!gameContinue) {
            Player player = new Player(inputView.inputNumber());
            Referee referee = new Referee();
            BallCount ballCount = referee.call(answers, player.getPickNumbers());
            ResultView resultView = new ResultView();
            resultView.printResult(ballCount);
            gameContinue = ballCount.isAllStrike();
        }
    }
//    public void start() {
//        inputView.printStartGame();
////        inputView.printAskInputNumber();
//    }
//    public void generateAnswer() {
//        generatedAnswer = numberGenerator.generateAnswer();
//    }
//    public void getInputNumber() {
//        input = inputView.inputNumber();
//        Player player1 = new Player(inputView.inputNumber());
//        pickNumbers = player.storeNumber(input);
//    }
//    public void getResult() {
//        String result = checkMachine.checkAnswer(generatedAnswer, pickNumbers);
//        resultView.showResult(result);
//        correct = referee.isOut(result);
//    }
//    public void askNextGame() {
//        if (correct) {
//            inputView.printAskGameEnd();
//            String gameContinueAnswer = inputView.askGameEnd();
//            gameContinue = player.isGameEnd(gameContinueAnswer);
//        }
}
