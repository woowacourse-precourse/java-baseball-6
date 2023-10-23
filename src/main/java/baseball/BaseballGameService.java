package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameService {
    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    private int strikes;
    private int balls;

    public List<Integer> generateComputerNumbers() {
        List<Integer> list = new ArrayList<>();

        while (list.size() < Variables.NUM.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }

        return list;
    }

    public List<Integer> parseInput(String input) {
        if (input.length() != Variables.NUM.getValue()) {
            throw new IllegalArgumentException(Variables.NUM.getValue() + "자리의 숫자를 입력해 주세요.");
        }

        return input.chars()
                .mapToObj(ch -> Character.getNumericValue((char) ch))
                .collect(Collectors.toList());
    }

    public void countStrikes(List<Integer> computerNumbers, List<Integer> userNumbers) {
        strikes = 0;

        for (int i = 0; i < Variables.NUM.getValue(); i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikes++;
            }
        }
    }

    public void countBalls(List<Integer> computerNumbers, List<Integer> userNumbers) {
        balls = 0;

        for (int i = 0; i < Variables.NUM.getValue(); i++) {
            if (!computerNumbers.get(i).equals(userNumbers.get(i)) && computerNumbers.contains(userNumbers.get(i))) {
               balls++;
            }
        }
    }
}

