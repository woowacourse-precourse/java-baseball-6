package baseball.domain;

import baseball.enums.GameStatus;

public record GameButton(int number) {
    public GameButton {
        validateNumber();
    }

    private void validateNumber() {
        int restartNumber = GameStatus.PLAY.getStatus().charAt(0);
        int exitNumber = GameStatus.EXIT.getStatus().charAt(0);
        if (number != restartNumber && number != exitNumber) {
            throw new IllegalArgumentException(String.format("게임 재시작은 %d, 종료는 %d이어야 합니다.", restartNumber, exitNumber));
        }
    }

    public boolean isRestart() {
        return number == GameStatus.PLAY.getStatus().charAt(0);
    }

    public boolean isExit() {
        return number == GameStatus.EXIT.getStatus().charAt(0);
    }
}
