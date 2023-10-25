package baseball.domain;

public enum GameStatus {

    PLAYING("게임 진행 중"),
    GAME_OVER("게임 종료");

    private final String description;

    GameStatus(String description) {
        this.description = description;
    }

}
