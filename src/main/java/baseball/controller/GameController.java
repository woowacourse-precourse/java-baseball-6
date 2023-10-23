package baseball.controller;

import baseball.exception.BallException;
import baseball.exception.ReGameException;
import baseball.service.GameService;
import baseball.view.GameOutput;
import baseball.view.UserInput;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class GameController {
    private final GameOutput output = new GameOutput();
    private final UserInput input = new UserInput();
    private final BallException ballException = new BallException();
    private final GameService gameService = new GameService();
    private final ReGameException reGameException = new ReGameException();

    public void start(){
        output.printGameStart();
        gameProcess();
    }

    public void gameProcess() {
        String number = input.inputUserNumber();
        ballException.validation(number);
        gameResult();
    }

    public void gameResult(){

    }

    public void reGameRequest(){
        output.printGameEnd();
        String request = input.inputGameRequest();
        reGameException.validation(request);

        int result = request.charAt(0) - '0';

        if (result == 1) gameRestart();
    }

    public void gameRestart(){
        gameProcess();
    }

}
