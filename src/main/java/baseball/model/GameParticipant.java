package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

enum GameStatusCode {
    PLAYING,
    STOP;
}
public class GameParticipant {
    private String playerGuessedNumber;
    private GameStatusCode playerStatus;
    private GameManager game;

    public GameParticipant() {
        this.playerStatus = GameStatusCode.PLAYING;
        this.game = new GameManager();
    }

    public GameStatusCode playGameByRequest() {
        while (playerStatus == GameStatusCode.PLAYING) {
            String guessedNumber = getUserInput();
            playerStatus = game.processTurn(guessedNumber);
        }

        System.out.println("3개의 숫자를 모두 맞췄습니다. 게임 종료");
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
        while (playerStatus != GameStatusCode.STOP) {
            playerStatus = playGameByRequest();
        }
    }

    private String getUserInput() {
        System.out.print("숫자를 입력해주세요: ");
        return Console.readLine();
    }

    private String askForReplay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
