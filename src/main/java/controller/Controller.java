package controller;

import view.InputView;
import model.CompareNumber;
import model.RandomNumber;
import view.OutputView;
import java.util.List;

public class Controller {
    public void Controll() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CompareNumber compareNumber = new CompareNumber();
        RandomNumber randomNumber = new RandomNumber();

        boolean restart = true;

        inputView.StartGameMessage(); // 게임시작 msg
        // 1. 입력값 받기 > 게임이 종료되지 않으면 (true면) 지속
        while (true) {
            inputView.InputMessage(); // 숫자 입력 msg
            // 결과 비교
            List<Integer> result = compareNumber.CompareComputerAndUser(inputView.InputUserNumber(), randomNumber.GenerateRandomNumber());
            // 결과 출력
            outputView.printResult(result);
            if (result.get(1) == 3) { // strike 3이면
                // 재시작 종료 여부
                inputView.StrikeGameSet();
                inputView.ReStart();
                restart = inputView.ProgramReStartOrExit();
            }
            if (!restart) { // false면 종료
                break;
            }
        }
    }
}
