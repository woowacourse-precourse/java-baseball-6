package baseball.controller;

import baseball.dto.GameStateDto;
import baseball.service.BaseballService;
import baseball.service.ComputerNumberGenerator;
import baseball.util.Validation;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    InputView inputView;
    OutputView outputView;
    Validation validation = new Validation();

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void playball() {
        String nowComNumber = getComputerNumber();
        while(true){
            outputView.printInputInitMessage();
            String userNumber = getUserNumber();
            BaseballService baseballService = new BaseballService(userNumber,nowComNumber);
            GameStateDto gamestate = baseballService.caculate();
            outputResult(gamestate);

        }


    }



    private void outputResult(GameStateDto gamestate) {
        int strike = gamestate.getStrike();
        int ball = gamestate.getBall();
        if(strike == 3) {
            threeThrikeOutput(strike);
            gamestate.activateEndGame();
        }
        else if(strike >0 && ball >0)
            outputView.strikeBall(strike, ball);
        else if(strike>0)
            outputView.onlyStrike(strike);
        else if(ball>0)
            outputView.onlyBall(ball);
        else if(strike==0 && ball==0)
            outputView.nothing();
    }

    private void threeThrikeOutput(int strike) {
        outputView.onlyStrike(strike);
        outputView.endGame();
        outputView.restart();
    }



    private String getComputerNumber() {
        ComputerNumberGenerator generator = ComputerNumberGenerator.getInstance();
        return validation.validateNumber(generator.generate());
    }

    private String getUserNumber() {
        String inputUserNumber = inputView.readUserNumber();
        return validation.validateNumber(inputUserNumber);
    }


}
