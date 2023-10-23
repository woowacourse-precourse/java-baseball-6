package view;

import view.processing.Convertor;
import view.processing.Validator;

import static utils.GameConstant.*;

public class OutputView {
    private final Convertor convertor;
    private final Validator validator;

    public OutputView(Convertor convertor, Validator validator) {
        this.convertor = convertor;
        this.validator = validator;
    }

    private void write(String message) {
        System.out.println(message);
    }

    public void startGame() {
        write(GAME_START_MESSAGE);
    }

    public void missionClear() {
        write(GAME_WIN_MESSAGE);
        write(GAME_RESTART_OR_QUIT_PROMPT);
    }

    public void hint(int strike, int ball) {
        String hintMessage = convertor.ballCountToHint(strike, ball);
        write(hintMessage);
    }

    public void inputPrompt() {
        write(INPUT_PROMPT_MESSAGE);
    }
}
