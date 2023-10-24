package baseball.service;

import baseball.hint.Printer;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    public BaseBallGame() {
        ServiceMessagePrinter.getServiceMessage("START");
    }

    public void startGame() {
        // 서로 다른 3자리 수를 컴퓨터가 지정한다.
        InitNumber initNumber = new InitNumber();
        String answer = initNumber.getInitNumber();

        while (true) {
            String message = GamePlaying.playingGame(answer);
            if (Printer.isFinished(message)) {
                boolean isEndGame = GameEnding.endGame(message);
                if (!isEndGame) {
                    startGame();
                    break;
                }
                Console.close();
                break;
            }
        }
    }
}
