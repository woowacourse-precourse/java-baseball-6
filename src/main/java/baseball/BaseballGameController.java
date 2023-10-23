package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameController {

    private BaseballGameViewer viewer;

    private int strikes;
    private int balls;

    public BaseballGameController(BaseballGameViewer viewer) {
        this.viewer = viewer;
    }

    public void playGame() {
        boolean restart = true;
        while (restart) {
            List<Integer> computerNumbers = generateComputerNumbers();

            boolean userflag = true;

            while (userflag) {
                String input = viewer.getUserGuess();
                List<Integer> userNumbers = parseInput(input);
                countStrikes(computerNumbers, userNumbers);
                countBalls(computerNumbers, userNumbers);
                viewer.displayResult(strikes, balls);

                if (strikes == Variables.NUM.getValue()) {
                    userflag = false;
                }
            }

            restart = viewer.hasNewGameMessage();
        }
    }

    private List<Integer> generateComputerNumbers() {
        List<Integer> list = new ArrayList<>();

        while (list.size() < Variables.NUM.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }

        return list;
    }

    private List<Integer> parseInput(String input) {
        if (input.length() != Variables.NUM.getValue()) {
            throw new IllegalArgumentException(Variables.NUM.getValue() + "자리의 숫자를 입력해 주세요.");
        }

        return input.chars()
                .mapToObj(ch -> Character.getNumericValue((char) ch))
                .collect(Collectors.toList());
    }

    private void countStrikes(List<Integer> computerNumbers, List<Integer> userNumbers) {
        strikes = 0;

        for (int i = 0; i < Variables.NUM.getValue(); i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikes++;
            }
        }
    }

    private void countBalls(List<Integer> computerNumbers, List<Integer> userNumbers) {
        balls = 0;

        for (int i = 0; i < Variables.NUM.getValue(); i++) {
            if (!computerNumbers.get(i).equals(userNumbers.get(i)) && computerNumbers.contains(userNumbers.get(i))) {
               balls++;
            }
        }
    }
}

