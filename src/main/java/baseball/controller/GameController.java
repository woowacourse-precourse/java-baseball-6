package baseball.controller;

import baseball.domain.Ball;
import baseball.exception.BallException;
import baseball.exception.ReGameException;
import baseball.service.GameService;
import baseball.view.GameOutput;
import baseball.view.UserInput;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class GameController {
    private List<BallDto> computer;
    private List<BallDto> user;
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
        createUserBall(number);
        gameResult();
    }

    public void gameResult(){
        int strikeResult = gameService.strikeResult(computer, user);
        int ballResult = gameService.ballResult(computer, user);

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

    public void createComputerBall() {
        computer = new ArrayList<>();
        List<Integer> validationList = new ArrayList<>();
        while (computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!validationList.contains(randomNumber)){
                validationList.add(randomNumber);
                Ball ball = new Ball(randomNumber);
                computer.add(new BallDto(ball.getNumber()));
            }
        }
    }

    public void createUserBall(String number){
        List<BallDto> userBall = new ArrayList<>();
        char[] charArray = number.toCharArray();
        for (char num : charArray) {
            Ball ball = new Ball(num - '0');
            userBall.add(new BallDto(ball.getNumber()));
        }
        this.user = userBall;
    }

    public List<BallDto> getComputer() {
        return computer;
    }

    public List<BallDto> getUser() {
        return user;
    }
}
