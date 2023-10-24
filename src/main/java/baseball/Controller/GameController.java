package baseball.Controller;


import baseball.Util.InputValidation;
import baseball.Util.NumberUtil;
import baseball.View.InputView;
import baseball.View.OutputView;
import baseball.Model.PlayNumber;

public class GameController {
    PlayNumber playNumber = new PlayNumber();
    ComputerController computerController = new ComputerController();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    InputValidation inputValidation = new InputValidation();
    NumberUtil numberUtil = new NumberUtil();

    public void playGame() {
        boolean isStart = true;
        while(isStart){
            GameStart();
            repeatAnswer();
            isStart = isGameContinue();
        }
    }

    private void GameStart(){
        outputView.startGame();
        computerController.StartGame(playNumber);
    }

    private void repeatAnswer() {
        boolean answer = false;
        while(!answer){
            validationPlayNumberInput();
            answer = computerController.checkStrikeAndBall(playNumber);
        }
    }

    private void validationPlayNumberInput() {
        String value = inputView.inputPlayNumber();
        inputValidation.validationNumber(value);
        playNumber.setInputNumberStr(value);
        playNumber.setInputNumbers(numberUtil.convertStringToIntList(value));
    }

    private boolean isGameContinue() {
        return Integer.parseInt(inputView.inputRestartNumber()) == 1 ? true : false;
    }
}