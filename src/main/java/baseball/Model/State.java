package baseball.Model;

public enum State {

    GAME_START,
    GAME_OVER,
    GAME_PLAY,
    GAME_RESTART,
    GAME_END;

    public State threeStrike(boolean strikeCount) {
        if (strikeCount) {
            return GAME_OVER;
        }
        if (!strikeCount) {
            return GAME_PLAY;
        }
        throw new IllegalArgumentException("오류 발생");
    }

    public State choiceGame(boolean choiceInput) {
        if (choiceInput) {
            return GAME_RESTART;
        }
        if (!choiceInput) {
            return GAME_END;
        }
        throw new IllegalArgumentException("허가되지 않은 문자열");
    }


}
