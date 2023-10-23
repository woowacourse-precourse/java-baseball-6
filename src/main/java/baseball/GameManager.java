package baseball;

import baseball.number.GameNumber;
import baseball.number.GameNumberGenerator;
import baseball.printer.ConsoleGamePrinter;
import baseball.printer.GamePrinter;
import baseball.receiver.ConsoleGameReceiver;
import baseball.receiver.GameReceiver;

import java.io.BufferedReader;

public class GameManager {

    private final GameReceiver gameReceiver;
    private final GamePrinter gamePrinter;

    public GameManager(BufferedReader receiver) {
        this.gameReceiver = new ConsoleGameReceiver(receiver);
        this.gamePrinter = new ConsoleGamePrinter();
    }

    public void run() {
        gamePrinter.greet();

        boolean restartStatus = true;

        while (restartStatus) {
            GameNumber gameNumber = new GameNumber(GameNumberGenerator.generateGameNumber());
            playBall(gameNumber);
//            restartStatus = askRestartGame();
        }
    }

    private void playBall(GameNumber gameNumber) {
        // 반복문
        // 입력 요청
        // checkUserNumber();
        // true -> 게임 끝
        // false -> 계속 진행
    }

    private boolean checkUserNumber(GameNumber gameNumber, GameNumber userNumber) {
        // userNumber 유효성 체크
        calculateBallCount(gameNumber, userNumber);
        return true;
    }

    private boolean calculateBallCount(GameNumber gameNumber, GameNumber userNumber) {
        Integer strikeCount;
        Integer ballCount;
        // 로직
        // GamePrinter로 출력
        return true;
    }
}
