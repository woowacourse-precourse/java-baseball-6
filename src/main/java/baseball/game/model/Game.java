package baseball.game.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Integer> randomAnswer;
    private Boolean isGameEnd;

    public Game() {
        this.randomAnswer = createRandomAnswer();
        this.isGameEnd = false;
    }

    private List<Integer> createRandomAnswer() {
        ArrayList<Integer> randomAnswer = new ArrayList<>();

        while (randomAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomAnswer.contains(randomNumber)) {
                randomAnswer.add(randomNumber);
            }
        }

        return randomAnswer;
    }

    public void validateInput(String input) {

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력받을 수 있습니다.");
        }

        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력해야합니다.");
        }

        for (int i = 0; i < 3; i++) {
            if (input.indexOf(input.charAt(i)) != i) {
                throw new IllegalArgumentException("각 자리의 수가 서로 달라야합니다.");
            }
        }
    }

    public int countStrike(String input) {
        List<Integer> inputList = stringToIntegerList(input);
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            Integer number = inputList.get(i);
            if (isStrike(number, i)) {
                strikeCount++;
            }
        }

        if (strikeCount == 3) {
            isGameEnd = true;
        }

        return strikeCount;
    }

    public boolean restartGame(String input) {
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isGamePlaying() {
        return !this.isGameEnd;
    }


    public int countBall(String input) {
        List<Integer> inputList = stringToIntegerList(input);
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            Integer number = inputList.get(i);
            if (isBall(number, i)) {
                ballCount++;
            }
        }
        return ballCount;
    }


    private List<Integer> stringToIntegerList(String str) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(str.charAt(i) - 48);
        }
        return list;
    }

    private Boolean isStrike(Integer number, int index) {
        return number.equals(randomAnswer.get(index));
    }

    private Boolean isBall(Integer number, int index) {
        return randomAnswer.contains(number) && (!number.equals(randomAnswer.get(index)));
    }
}
