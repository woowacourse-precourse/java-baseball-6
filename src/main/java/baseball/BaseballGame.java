package baseball;

import baseball.view.InputView;
import baseball.view.OutView;

public class BaseballGame {

    public void start() {
        do{
            OutView.gameStartPrint();
            proses(new Computer());
            OutView.endGamePrint();
        }while (confirmGameRestart());
    }

    //게임 진행
    private void proses(Computer computer) {
        int strikeCount;
        do {
            OutView.numberInputPrint();
            int number = InputView.promptForThreeNumbers();
            Ball ball = new Ball(number);
            BallResult userBallResult = computer.getUserBallResult(ball);
            OutView.ballScoringResultsPrint(userBallResult);
            strikeCount = userBallResult.getStrike();
        } while (isGameOverWithStrikeCount(strikeCount)); //3스트라이크 일 경우 종료
    }

    //게임 재시작 여부
    private boolean confirmGameRestart() {
        OutView.restartGamePrint();
        return InputView.promptForOneNumbers() == 1;
    }

    private boolean isGameOverWithStrikeCount(int strikeCount) {
        return strikeCount < 3;
    }
}
