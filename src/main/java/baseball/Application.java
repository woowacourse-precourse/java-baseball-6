package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String RESTART_COMMAND = "1";
    private static final String EXIT_COMMAND = "2";

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            startGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } while (isRestartGame());
    }

    private static void startGame() {
        Computer computer = new Computer();
        Player player = new Player();
        do {
            System.out.print("숫자를 입력해주세요 : ");
            player.setPlayerNumber(Console.readLine());
            computer.printResult(player.getPlayerNumber());
        } while (!isClear());
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static boolean isClear() {
        return BaseballNumber.getStrike() == BaseballNumber.getAnswer();
    }

    private static boolean isRestartGame() {
        String command = Console.readLine();
        validateCommand(command);
        return command.equals(RESTART_COMMAND);
    }

    private static void validateCommand(String command) {
        if (!isRestartCommand(command) && !isExitCommand(command)) {
            throw new IllegalArgumentException("INVALID COMMAND");
        }
    }

    private static boolean isRestartCommand(String command) {
        return command.equals(RESTART_COMMAND);
    }

    private static boolean isExitCommand(String command) {
        return command.equals(EXIT_COMMAND);
    }
}
