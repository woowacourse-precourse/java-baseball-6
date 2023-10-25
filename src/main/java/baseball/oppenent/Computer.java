package baseball.oppenent;

import baseball.config.GameProperty;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {

    private List<Integer> randomNumber = new ArrayList<>();

    private void Comparator() {
    }

    public Computer() {
        setRandomNumber();
    }

    public void setRandomNumber() {
        randomNumber.clear();
        while (randomNumber.size() < GameProperty.getAnswerlength()) {
            int stRange = GameProperty.getStRange();
            int edRange = GameProperty.getEdRange();
            int pickedNumber = Randoms.pickNumberInRange(stRange, edRange);
            if (!this.randomNumber.contains(pickedNumber)) {
                this.randomNumber.add(pickedNumber);
            }
        }
    }

    public Map<String, Integer> getHint(List<Integer> userAnswer) {
        Map<String, Integer> hint = new HashMap<>();
        hint.put("strike", getStrike(userAnswer));
        hint.put("ball", getBall(userAnswer));
        return hint;
    }

    private int getStrike(List<Integer> userAnswer) {
        int strike = 0;
        for (int i = 0; i < userAnswer.size(); i++) {
            if (this.randomNumber.get(i) == userAnswer.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int getBall(List<Integer> userAnswer) {
        int ball = 0;
        for (int i = 0; i < userAnswer.size(); i++) {
            if (randomNumber.get(i) != userAnswer.get(i)
                    && this.randomNumber.contains(userAnswer.get(i))) {
                ball++;
            }
        }
        return ball;
    }

}
