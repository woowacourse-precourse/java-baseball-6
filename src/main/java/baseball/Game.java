package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private final Input input;
    private final Judge judge;
    private final Output output;

    public Game() {
        String computerNumber = getComputerNumber();
        input = new Input();
        judge = new Judge(computerNumber);
        output = new Output();
    }

    public boolean start() {
        boolean isCorrect = false;
        while (!isCorrect) {
            output.askNumber();
            String userNumber = input.askUserNumber();
            JudgeResult result = judge.of(userNumber);
            output.printResult(result);
            isCorrect = isCorrect(result);
        }
        return input.askGameOver();
    }

    private boolean isCorrect(JudgeResult result) {
        return result.getStatus() == JudgeStatus.CORRECT;
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
