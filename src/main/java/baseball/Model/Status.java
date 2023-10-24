package baseball.Model;

public enum Status {

    GAME_START,
    GAME_OVER,
    GAME_PLAY,
    GAME_RESTART,
    GAME_END;

    public Status threeStrike(boolean strikeCount) {
        if (strikeCount) {
            return GAME_OVER;
        }
        if (!strikeCount) {
            return GAME_PLAY;
        }
        throw new IllegalArgumentException("오류 발생");
    }

    public static Status choiceGame(String choiceInput) {
        if (choiceInput.equals("1")) {
            return GAME_RESTART;
        }
        if (choiceInput.equals("2")) {
            return GAME_END;
        }
        throw new IllegalArgumentException("허가되지 않은 문자열");
    }


}
