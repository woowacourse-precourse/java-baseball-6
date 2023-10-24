package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.exception.BallException;
import baseball.exception.ReGameException;
import baseball.service.GameService;
import baseball.view.GameOutput;
import baseball.view.UserInput;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class GameController {
    private Computer computer;
    private Player player;
    private final GameOutput output = new GameOutput();
    private final UserInput input = new UserInput();
    private final BallException ballException = new BallException();
    private final GameService gameService = new GameService();
    private final ReGameException reGameException = new ReGameException();

    public void start(){
        createComputerBall();
        output.printGameStart();
        gameProcess();
    }

    public void gameProcess() {
        String number = input.inputUserNumber();
        ballException.validation(number);
        createPlayerBall(number);
        gameResult();
    }

    public void gameResult(){
        String computerBall = computer.getBallNumber();
        String playerBall = player.getBallNumber();
        int strikeResult = gameService.strikeResult(computerBall, playerBall);
        int ballResult = gameService.ballResult(computerBall, playerBall);

        if (strikeResult == 3) reGameRequest();

        if (strikeResult != 3){
            output.printGameResult(strikeResult, ballResult);
            gameProcess();
        }
    }

    public void reGameRequest(){
        output.printGameEnd();
        String request = input.inputGameRequest();
        reGameException.validation(request);

        int result = request.charAt(0) - '0';

        if (result == 1) gameRestart();
    }

    public void gameRestart(){
        createComputerBall();
        gameProcess();
    }

    private void createComputerBall(){
        List<Integer> ballList = new ArrayList<>();
        while (ballList.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!ballList.contains(randomNumber)){
                ballList.add(randomNumber);
            }
        }
        computer = new Computer(ballList);
    }

    private void createPlayerBall(String number){
        List<Integer> ballList = new ArrayList<>();
        for (char num : number.toCharArray()) {
            ballList.add(num - '0');
        }
        player = new Player(ballList);
    }
}
