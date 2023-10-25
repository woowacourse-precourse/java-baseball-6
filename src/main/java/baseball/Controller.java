package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {
    private static final String RESTART_REQUEST_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GAME_START = "1";
    private static final String PROGRAM_EXIT = "2";

    public Controller() {
    }

    public void start() {
        String state = GAME_START;
        Computer computer = new Computer();
        Game game = new Game(computer);
        while (state.equals(GAME_START)) {
            game.init();
            game.play();
            printRestartRequestMessage();
            state = readLine();
            validateRange(state);
        }
    }

    private void printRestartRequestMessage() {
        System.out.println(RESTART_REQUEST_MESSAGE);
    }

    private void validateRange(String state) {
        if (!state.equals(GAME_START)
                && !state.equals(PROGRAM_EXIT)) {
            throw new IllegalArgumentException("the input is not 1 or 2");
        }
    }
}