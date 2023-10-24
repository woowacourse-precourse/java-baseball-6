package view;

import static utils.GameConstant.GAME_RESTART_OR_QUIT_PROMPT;
import static utils.GameConstant.GAME_START_MESSAGE;
import static utils.GameConstant.GAME_WIN_MESSAGE;
import static utils.GameConstant.INPUT_PROMPT_MESSAGE;

import view.processing.Convertor;
import view.processing.Validator;

public final class OutputView {

    private final Convertor convertor;
    private final Validator validator;

    public OutputView(Convertor convertor, Validator validator) {
        this.convertor = convertor;
        this.validator = validator;
    }

    private void write(String message) {
        System.out.println(message);
    }

    public void printGameStartConsole() {
        write(GAME_START_MESSAGE);
    }

    public void printMissionClearConsole() {
        write(GAME_WIN_MESSAGE);
        write(GAME_RESTART_OR_QUIT_PROMPT);
    }

    public void printHintConsole(int strike, int ball) {
        validator.totalCountsNotExceedingLimit(strike, ball);
        String hintMessage = convertor.ballCountToHint(strike, ball);
        write(hintMessage);
    }

    public void inputPrompt() {
        write(INPUT_PROMPT_MESSAGE);
    }
}
