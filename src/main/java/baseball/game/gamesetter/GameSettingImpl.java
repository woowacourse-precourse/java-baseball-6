package baseball.game.gamesetter;

import baseball.AppConfig;
import baseball.GameStatus;
import baseball.game.CheckingBoard;
import baseball.game.Score;
import baseball.game.displayboard.DisplayBoard;
import baseball.game.hitter.Hitter;
import baseball.game.pitcher.Pitcher;
import baseball.game.umpire.Umpire;
import baseball.game.util.IllegalArgumentCheck;
import camp.nextstep.edu.missionutils.Console;

public class GameSettingImpl implements GameSetting {
    AppConfig appConfig = new AppConfig();
    DisplayBoard displayBoard = appConfig.displayBoard();
    @Override
    public void startGame() {
        displayBoard.displayGameStart();
    }

    @Override
    public void progressGame() {
        String ball = "";
        String bat = "";
        Score score = new Score();
        CheckingBoard checkingBoard = new CheckingBoard();

        //appConfig 의존성 주입
        Pitcher pitcher = appConfig.pitcher();
        Hitter hitter = appConfig.hitter();
        Umpire umpire = appConfig.umpire();

        //투수 공 던지기(랜덤 숫자 생성)
        ball = pitcher.pitch();

        //반복 종료 조건: score에 홈런여부가 true일 경우
        while (true) {
            displayBoard.displayRequestNum();
            //타자 배트 휘두르기(사용자의 입력 받아 숫자 생성)
            bat = hitter.swing();
            //심판 스트라이크 확인
            checkingBoard = umpire.checkStrike(ball, bat, checkingBoard);
            //심판 볼 확인
            checkingBoard = umpire.checkBall(ball, bat, checkingBoard);
            //심판 판정
            score = umpire.judge(checkingBoard, score);
            displayBoard.displayScore(score);
            //반복 종료 조건
            if (score.isHomerunCount()) {
                break;
            }
            //게임 지속 진행을 위한 초기화
            score.initAll();
            checkingBoard.initAll();
        }

    }

    @Override //게임 재시작 여부 확인
    public GameStatus questionRestartGame(GameStatus gameStatus) {
        IllegalArgumentCheck illegalArgumentCheck = new IllegalArgumentCheck();
        displayBoard.displayQuestionRestart();
        //사용자 답변 받기
        String inputAnswer = Console.readLine();
        //잘못된 답변(사용자 입력)확인
        illegalArgumentCheck.checkArgumentWrongAnswer(inputAnswer);
        //게임상태 변경하여 게임 종료 조건 달성
        if (inputAnswer.charAt(0) == '2') {
            gameStatus = GameStatus.STOP;
        }
        return gameStatus;
    }
}
