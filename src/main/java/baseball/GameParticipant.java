package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class GameParticipant {
    private String playerGuessedNumber;
    private GameStatus playerStatus;
    private GameManager game;

    public GameParticipant() {
        this.playerStatus = GameStatus.PLAYING;
        this.game = new GameManager();
    }

    public GameStatus playGameByRequest() {
        while (playerStatus == GameStatus.PLAYING) {
            String guessedNumber = getUserInput();
            playerStatus = game.processTurn(guessedNumber);
        }

        System.out.println("3개의 숫자를 모두 맞췄습니다. 게임 종료");
        String replayChoice = askForReplay();
        if (Objects.equals(replayChoice, "1")) {
            playerStatus = GameStatus.PLAYING;
            game = new GameManager(); // 새로운 게임 객체 생성
        } else if (Objects.equals(replayChoice, "2")) {
            playerStatus = GameStatus.STOP;
        } else {
            throw new IllegalArgumentException("잘못된 선택입니다.");
        }

        return playerStatus;
    }

    public void run() {
        while (playerStatus != GameStatus.STOP) {
            playerStatus = playGameByRequest();
        }
    }

    private String getUserInput() {
        System.out.print("숫자를 입력해주세요: ");
        return Console.readLine();
    }

    private String askForReplay() {
        System.out.print("다시 플레이? (1: Yes, 2: No): ");
        return Console.readLine();
    }
}
