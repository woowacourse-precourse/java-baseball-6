package baseball;

import baseball.view.InputView;
import baseball.view.OutView;

public class BaseballGame {

    public void start() {
        do{
            OutView.gameStartPrint();
            Computer computer = new Computer();

            //반복
            proses(computer);

            //게임 종료
            OutView.endGamePrint();

        }while (confirmGameRestart());
    }

    //게임 진행
    private void proses(Computer computer) {
        do {
            OutView.numberInputPrint();
            int number = InputView.promptForThreeNumbers();
            Ball ball = new Ball(number);
            BallResult userBallResult = computer.getUserBallResult(ball);

            //결과 출력
            OutView.ballScoringResultsPrint(userBallResult);

            if (userBallResult.getStrike() >= 3) {
                break;
            }
        }while (true); //3스트라이크 일 경우 종료
    }

    //게임 재시작 여부
    private boolean confirmGameRestart() {
        OutView.restartGamePrint();
        return InputView.promptForOneNumbers() == 1;
    }
}
