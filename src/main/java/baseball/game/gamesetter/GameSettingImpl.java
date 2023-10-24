package baseball.game.gamesetter;

import baseball.AppConfig;
import baseball.game.CheckingBoard;
import baseball.game.Score;
import baseball.game.gamesetter.GameSetting;

import java.util.Arrays;

import static baseball.AppConfig.DIGIT_NUM;

public class GameSettingImpl implements GameSetting {
    AppConfig appConfig = new AppConfig();
    @Override
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void initGame(CheckingBoard checkingBoard, Score score) {
        Boolean[] initBoard = new Boolean[DIGIT_NUM];
        Arrays.fill(initBoard, false);
        checkingBoard.setStrikeCheckingBoard(initBoard);
        checkingBoard.setBallCheckingBoard(initBoard);
        score.setAll(0, 0, false, false);
    }

    @Override
    public void progressGame() {
        String ball = "";
        String bat = "";
        Score score = new Score();
        CheckingBoard checkingBoard = new CheckingBoard();

        ball = appConfig.pitcher().pitch();

        System.out.print("숫자를 입력해주세요 : ");
        bat = appConfig.hitter().swing();
        checkingBoard = appConfig.umpire().checkStrike(ball, bat, checkingBoard);
        checkingBoard = appConfig.umpire().checkBall(ball, bat, checkingBoard);
        score = appConfig.umpire().judge(checkingBoard, score);

        if(score.getBallCount() > 0){
            System.out.print(score.getBallCount());
        }
        if(score.getStrikeCount() > 0){
            System.out.print(score.getStrikeCount());
        }

    }

    @Override
    public void questionRestartGame() {

    }

    @Override
    public void setGame() {

    }
}
