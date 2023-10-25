package baseball;

public class GameManager {

    private static GameManager gameManager;
    private static final String RESTART_INPUT = "1";
    private Answer answer;

    private GameManager() {
    }

    public static GameManager createGameManager() {
        if (gameManager == null) {
            gameManager = new GameManager();
        }
        return gameManager;
    }

    public void startGame() {
        answer = Answer.createNewAnswer();
        Writer.writeStartMent();
        proceedGame();
    }

    private void proceedGame() {
        while (true) {

            Writer.writeInputMent();
            String answerInput = Reader.readInput();
            Validator.validateAnswerInput(answerInput);

            GradeResult gradeResult = answer.gradeInput(answerInput);

            Writer.writeGradeResult(gradeResult);

            if (gradeResult.isAnswer()) {
                Writer.writeCorrectMent();
                break;
            }

        }

        Writer.writeRestartMent();
        String endInput = Reader.readInput();
        Validator.validateRestartInput(endInput);
        nextGame(endInput);
    }

    private void nextGame(String endInput) {
        if (endInput.equals(RESTART_INPUT)) {
            startGame();
        }
    }
}
