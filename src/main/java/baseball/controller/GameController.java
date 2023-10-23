package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserInputNumber;
import baseball.model.UserRestartNumber;
import baseball.view.OutputView;
import baseball.view.UserInputView;
import baseball.utils.CompareBallStrike;
import java.util.List;

public class GameController {
    private final ComputerNumber computer;

    public GameController() {
        computer = new ComputerNumber();
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    //    게임 전체 시작 및 재시작
    public void gameEngine() {
        while (true) {
            computer.setComputerNumber();
            gamePlay();

            UserRestartNumber userRestart = new UserRestartNumber(UserInputView.getUserInputRestart());
            if(userRestart.getRestartNumber().equals("2")){
                break;
            }
        }
    }

    //    게임 1회 시작
    public void gamePlay() {
        List<Integer> listBallStrike;

        do {
            UserInputNumber userInput = new UserInputNumber(UserInputView.getUserInputNumber());
            listBallStrike = CompareBallStrike.compareComputerNumberAndUserInput(computer.getComputerNumber(), userInput.getUserInputNumber());
            OutputView.printBallStrike(listBallStrike);
        } while (listBallStrike.get(1) != 3);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
