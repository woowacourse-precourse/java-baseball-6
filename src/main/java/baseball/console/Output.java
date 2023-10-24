package baseball.console;

public class Output {

    public void printBaseballGameHint(String result) {
        System.out.println(result);
    }

    public void printBaseballGameStart() {
        System.out.println(Constant.START_BASEBALL_GAME_MESSAGE);
    }

    public void printBaseballGameTermination() {
        System.out.println(Constant.TERMINATION_BASEBALL_GAME_MESSAGE);
    }

    public void printBaseballGameNumberRequest() {
        System.out.println(Constant.INPUT_BASEBALL_GAME_NUMBERS_MESSAGE);
    }

    public void printBaseballGameRestartNumberRequest() {
        System.out.println(Constant.INPUT_BASEBALL_GAME_RESTART_MESSAGE);
    }
}
