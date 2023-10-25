package baseball.service;

import camp.nextstep.edu.missionutils.Console;

/**
 * 6. restartOrExit() : 게임 종료 후 다시 시작하거나 완전히 완료 시킬지 결정 (1: 새로 시작, 2: 종료)
 */
public class Restart {
    private final UserValidation userValidation;

    public Restart(UserValidation userValidation) {
        this.userValidation = userValidation;
    }

    public int restartOrExit() {
        String restart = Console.readLine();
        int userInput = userValidation.restartValid(restart);

        return userInput;
    }
}