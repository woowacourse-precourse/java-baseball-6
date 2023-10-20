package baseball;

enum GameStatus {

    START("1"), GAME_OVER("2");

    final String value;

    GameStatus(String value) {
        this.value = value;
    }
}
