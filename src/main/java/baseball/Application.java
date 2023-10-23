package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        setRandomNumberToComputer(computer);

        View view = new View();
        view.printGameStartingMsg();
        Input input = new Input();
        while (true) {
            view.printInputMessage();
            final String inputNumberStr = input.getNumberInput();
            Score score = getCompareResultWithInputNumberAndComputerNumber(
                    inputNumberStr, computer);
            view.printScore(score);
            if (score.hasWinScore()) {
                String inputNum = input.getGameExitOrRestartInput();
                if (Integer.parseInt(inputNum) == 1) {
                    computer = new ArrayList<>();
                    setRandomNumberToComputer(computer);
                }
                if (Integer.parseInt(inputNum) == 2) {
                    break;
                }
            }
        }
    }

    private static Score getCompareResultWithInputNumberAndComputerNumber(String inputNumberStr,
                                                                          List<Integer> computer) {
        Score score = new Score();
        for (int i = 0; i < inputNumberStr.length(); i++) {
            int inputNumberAt = Character.getNumericValue(inputNumberStr.charAt(i));
            if (computer.get(i) == inputNumberAt) {
                score.increaseStrikeCount();
            } else if (computer.contains(inputNumberAt)) {
                score.increaseBallCount();
            }
        }
        return score;
    }

    private static void setRandomNumberToComputer(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
