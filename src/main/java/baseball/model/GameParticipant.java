package baseball.model;

import baseball.view.ResultView;
import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

enum GameStatusCode {
    PLAYING,
    STOP
}
public class GameParticipant {
    private GameStatusCode playerStatus;
    private GameManager game;

    public GameParticipant() {
        this.playerStatus = GameStatusCode.PLAYING;
        this.game = new GameManager();
    }

    private GameStatusCode playGameByRequest() {
        while (playerStatus == GameStatusCode.PLAYING) {
            String guessedNumber = getUserInput();
            playerStatus = game.processTurn(guessedNumber);
        }

        ResultView.endMessage();
        String replayChoice = askForReplay();
        if (Objects.equals(replayChoice, "1")) {
            playerStatus = GameStatusCode.PLAYING;
            game = new GameManager(); // 새로운 게임 객체 생성
        } else if (Objects.equals(replayChoice, "2")) {
            playerStatus = GameStatusCode.STOP;
        } else {
            throw new IllegalArgumentException("잘못된 선택입니다.");
        }

        return playerStatus;
    }

    public void run() {
        ResultView.startMessage();
        while (playerStatus != GameStatusCode.STOP) {
            playerStatus = playGameByRequest();
        }
    }

    private String getUserInput() {
        ResultView.processMessage();
        return Console.readLine();
    }

    private String askForReplay() {
        ResultView.isReplayMessage();
        return Console.readLine();
    }
}
