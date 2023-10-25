package baseball;

import static baseball.CONSTANT.GAME_END;
import static baseball.CONSTANT.GAME_RESTART;
import static baseball.CONSTANT.GAME_SIZE;
import static baseball.CONSTANT.GAME_START;
import static baseball.CONSTANT.NEXT_SIZE;

import baseball.controller.BasicController;
import baseball.view.ProcessView;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private BasicController controller;
    private int nextNum;

    public boolean startGame() {
        if (controller == null) {
            controller = new BasicController();
        }

        nextNum = GAME_START;
        controller.createComputerNumber();

        while (nextNum == GAME_START) {
            ProcessView.printRequireInput();
            String userNum = Console.readLine();
            validateInputSize(userNum, GAME_SIZE);

            if (controller.checkNumber(userNum)) {
                String nextStep = Console.readLine();
                validateNextInput(nextStep);
            }
        }

        if (nextNum == GAME_END) {
            return false;
        }

        return true;
    }

    private void validateInputSize(String userInput, Integer requiredSize) {
        if (userInput.length() != requiredSize) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
    }

    private void validateNextInput(String userInput) {
        validateInputSize(userInput, NEXT_SIZE);
        int tmp = Integer.parseInt(userInput);
        if (tmp != GAME_RESTART && tmp != GAME_END) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
        nextNum = tmp;
    }

}
