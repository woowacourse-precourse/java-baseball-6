package baseball.controller;

import baseball.Compare;
import baseball.Computer;
import baseball.GameStatus;
import baseball.dto.BallAndStrike;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    Computer computer = new Computer();
    Compare compare = new Compare();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void start(){
        int gameStatus = GameStatus.PLAY.status;
        outputView.printGameStartMessage();
        //
        List<Integer> answer = computer.makeNewNumber();
        // gameStatus가 PLAY 인 경우만
        while(gameStatus == GameStatus.PLAY.status){
            gameStatus = play(answer);
        }
    }

    public int play(List<Integer> answer){
        while(true){
            //userInput 생성
            List<Integer> userInput = inputView.getUserInput();
            //userInput,answer 비교해서 ball, strike 값 구함
            BallAndStrike data = compare.makeBallAndStrikeData(userInput, answer);
            //ball, strike 값 출력
            outputView.printBallAndStrike(data.getBall(), data.getStrike());
            // strike == 3, 즉, 정답을 맞추면 while문 탈출
            if(data.getStrike() == 3)
                break;
        }
        //
        return inputView.askForNewGame();
    }


}
