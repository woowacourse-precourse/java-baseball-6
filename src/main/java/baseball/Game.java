package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.JudgeStatus.CORRECT;
import static baseball.JudgeStatus.NOTHING;

class Game {

    static final int NUMBER_LENGTH = 3;

    private final Input input;
    private final Judge judge;
    private final Output output;

    Game() {
        String computerNumber = getComputerNumber();
        input = new Input();
        judge = new Judge(computerNumber);
        output = new Output();
    }

    GameStatus start() {
        JudgeStatus status = NOTHING;
        while (!status.equals(CORRECT)) {
            output.askUserNumber();
            String userNumber = input.askUserNumber();
            JudgeResult result = judge.of(userNumber);
            output.printResult(result);
            status = result.getStatus();
        }
        return input.askGameOver();
    }

    private String getComputerNumber() {
        StringBuilder computer = new StringBuilder();
        while (computer.length() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computer.toString().contains(randomNumber)) {
                computer.append(randomNumber);
            }
        }
        return computer.toString();
    }
}
