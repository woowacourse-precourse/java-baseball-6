package baseball;

public class ProgramManager {

    private final String RESTART_INPUT = "1";
    private Answer answer;


    public ProgramManager() {
    }

    public void startGame() {
        answer = Answer.from();
        Writer.writeStartMent();
        proceedGame();
    }

    public void proceedGame() {
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

    public void nextGame(String endInput) {
        if (endInput.equals(RESTART_INPUT)) {
            startGame();
        }
    }
}
