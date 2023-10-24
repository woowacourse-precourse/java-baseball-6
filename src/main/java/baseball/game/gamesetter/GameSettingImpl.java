package baseball.game.gamesetter;

import baseball.AppConfig;
import baseball.GameStatus;
import baseball.game.CheckingBoard;
import baseball.game.Score;
import baseball.game.displayboard.DisplayBoard;
import baseball.game.util.IllegalArgumentCheck;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

import static baseball.AppConfig.DIGIT_NUM;

public class GameSettingImpl implements GameSetting {
    AppConfig appConfig = new AppConfig();
    DisplayBoard displayBoard = appConfig.displayBoard();
    @Override
    public void startGame() {
        displayBoard.displayGameStart();
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

        while (true) {
            displayBoard.displayRequestNum();
            bat = appConfig.hitter().swing();
            checkingBoard = appConfig.umpire().checkStrike(ball, bat, checkingBoard);
            checkingBoard = appConfig.umpire().checkBall(ball, bat, checkingBoard);
            score = appConfig.umpire().judge(checkingBoard, score);
            displayBoard.displayScore(score);
            if(score.isHomerunCount()){
                break;
            }
            score.initAll();
            checkingBoard.initAll();
        }

    }

    @Override
    public GameStatus questionRestartGame(GameStatus gameStatus) {
        IllegalArgumentCheck illegalArgumentCheck = new IllegalArgumentCheck();
        displayBoard.displayQuestionRestart();
        String inputAnswer = Console.readLine();
        illegalArgumentCheck.checkArgumentWrongAnswer(inputAnswer);
        if(inputAnswer.charAt(0) == '2'){
            gameStatus = GameStatus.STOP;
        }
        return gameStatus;
    }

    @Override
    public void setGame() {

    }
}
