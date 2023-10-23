package baseball.domain;

public enum GameStatus {
    WIN, PLAYING;

    public static boolean isPlaying(GameStatus gameStatus) {
        return gameStatus == PLAYING;
    }
}
