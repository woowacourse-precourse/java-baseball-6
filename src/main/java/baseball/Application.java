package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String RESTART = "1";
    private static final String EXIT = "2";

    public static void main(String[] args) {
        boolean runningFlag = true;

        while (runningFlag) {
            startGame();

            runningFlag = isRestart();
        }

        Console.close();
    }

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static boolean isRestart() {
        String userInput = Console.readLine();

        return switch (userInput) {
            case RESTART -> true;
            case EXIT -> false;
            default -> throw new IllegalArgumentException();
        };
    }
}
