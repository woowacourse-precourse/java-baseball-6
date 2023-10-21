package baseball;

import baseball.view.InputView;
import baseball.view.OutView;

public class BaseballGame {
    private final Computer computer = new Computer();

    public void start() {
        do{
            OutView.gameStartPrint();
            proses();
            OutView.endGamePrint();
        }while (confirmGameRestart());
    }

    //게임 진행
    private void proses() {
        BallArray ballArray;
        computer.setRandomBallArray();
        do {
            OutView.numberInputPrint();
            int number = InputView.promptForNumbers();
            ballArray = BaseballBallFactory.createManualBall(number);
        } while (isGameOverWithStrikeCount(ballArray)); //3스트라이크 일 경우 종료
    }

    //게임 재시작 여부
    private boolean confirmGameRestart() {
        OutView.restartGamePrint();
        return InputView.promptForNumbers() == 1;
    }

    private boolean isGameOverWithStrikeCount(BallArray ballArray) {
        BallResultDto userBallResultDto = computer.getUserBallResult(ballArray);
        OutView.ballScoringResultsPrint(userBallResultDto);
        return userBallResultDto.getStrike() < 3;
    }
}
