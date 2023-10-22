package baseball.domain;

import baseball.enums.GameConfig;

public record GameButton(int number) {
    public GameButton {
        validateNumber();
    }

    private void validateNumber() {
        int restartNumber = GameConfig.GAME_RESTART.getValue();
        int exitNumber = GameConfig.GAME_EXIT.getValue();
        if (number != restartNumber && number != exitNumber) {
            throw new IllegalArgumentException(String.format("게임 재시작은 %d, 종료는 %d이어야 합니다.", restartNumber, exitNumber));
        }
    }
}
