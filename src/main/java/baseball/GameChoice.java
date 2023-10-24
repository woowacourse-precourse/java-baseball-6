package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameChoice {
    private static final String GAME_RESTART_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GAME_EXIT_MESSAGE = "게임 종료";

    public boolean choiceRestart() {
        System.out.println(GAME_RESTART_PROMPT);
        String choice = Console.readLine();
        return handleChoice(choice);
    }

    private boolean handleChoice(String choice) {
        return switch (choice) {
            case "1" -> true;
            case "2" -> {
                System.out.println(GAME_EXIT_MESSAGE);
                yield false;
            }
            default -> throw new IllegalArgumentException("잘못된 입력입니다. " + GAME_RESTART_PROMPT);
        };
    }
}
