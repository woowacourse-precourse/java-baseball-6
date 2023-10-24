package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {
    private static final String RESTART_REQUEST_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART_GAME = "1";
    private static final String PROGRAM_EXIT = "2";

    public Controller() {
    }

    public void startGame() {
        Computer computer = new Computer();
        Player player = new Player();
        String status;

        do {
            player.init();
            player.play();
            printRestartRequestMessage();
            status = readLine();
            validateRestartRange(status);
        } while (RESTART_GAME.equals(status));
    }

    private void printRestartRequestMessage() {
        System.out.println(RESTART_REQUEST_MESSAGE);
    }

    private void validateRestartRange(String status) {
        if (!status.equals(RESTART_GAME) && !status.equals(PROGRAM_EXIT)) {
            throw new IllegalArgumentException("입력이 1 또는 2가 아닙니다.");
        }
    }
}
