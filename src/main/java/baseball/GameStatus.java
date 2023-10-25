package baseball;

public enum GameStatus {

    GAME_START,
    INNING_START,
    INNING_END,
    GAME_END,
    ;

    public static GameStatus fromGameCommand(GameCommand gameCommand) {
        if (gameCommand.isContinue()) {
            return GAME_START;
        }
        return GAME_END;
    }

    public static boolean isGameEnd(GameStatus gameStatus) {
        return gameStatus == GAME_END;
    }

    public static boolean isInningEnd(GameStatus gameStatus) {
        return gameStatus == INNING_END;
    }

    public static GameStatus fromResult(Result result) {
        if (result.isThreeStrikes()) {
            return INNING_END;
        }
        return INNING_START;
    }
}
