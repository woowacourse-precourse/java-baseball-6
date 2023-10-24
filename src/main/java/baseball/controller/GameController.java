package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.ComputerNumber;
import baseball.domain.GameResult;
import baseball.domain.UserInputNum;
import baseball.service.ValidationInput;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    ComputerNumber computerNumber = new ComputerNumber();
    OutputView outputView = new OutputView();
    UserInputNum userInputNum = new UserInputNum();
    BaseballGame baseballGame = new BaseballGame();
    ValidationInput validationInput = new ValidationInput();
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String restartFlag;
        do{
            run();
            restartFlag = validationInput.askGameRestart();
        }while(restartFlag.equals("1"));
        System.out.println("게임 종료.");
    }

    private void run(){
        GameResult gameResult;
        List<String> computerNum = computerNumber.createComputerNumber();
        do{
            List<String> playerNum = userInputNum.getUserInput();
            gameResult = baseballGame.compareNumList(playerNum, computerNum);
            outputView.printBallAndStrike(gameResult.getBall(), gameResult.getStrike());
//            String result = printBallAndStrike2(gameResult.getBall(), gameResult.getStrike());
//            System.out.println(result);
        }while(gameResult.getStrike() != 3);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
