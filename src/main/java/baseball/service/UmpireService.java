package baseball.service;

import java.util.ArrayList;
import java.util.Objects;
import static baseball.util.Constants.*;

public class UmpireService {
    private int ballCount = 0;
    private int strikeCount = 0;

    public UmpireService() {
        initCount();
    }

    public void initCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public ArrayList<Integer> getResult(ArrayList<Integer> randomNumbers, ArrayList<Integer> inputNumbers) {
        ArrayList<Integer> ballStrikeCount = new ArrayList<>();
        ballStrikeCount.add(getBallCount(randomNumbers, inputNumbers));
        ballStrikeCount.add(getStrikeCount(randomNumbers, inputNumbers));
        return ballStrikeCount;
    }

    private int getStrikeCount(ArrayList<Integer> randomNumbers, ArrayList<Integer> inputNumbers) {
        for (int i = 0; i < randomNumbers.size() && i < inputNumbers.size(); i++) {
            int inputNumber = inputNumbers.get(i);
            if (Objects.equals(randomNumbers.get(i), inputNumber)) {
                this.strikeCount++;
            }
        }
        return strikeCount;
    }

    private int getBallCount(ArrayList<Integer> randomNumbers, ArrayList<Integer> inputNumbers) {
        for (int i = 0; i < randomNumbers.size() && i < inputNumbers.size(); i++) {
            int inputNumber = inputNumbers.get(i);
            if (!(Objects.equals(randomNumbers.get(i), inputNumber)) && randomNumbers.contains(inputNumber)) {
                this.ballCount++;
            }
        }
        return ballCount;
    }

    public String getRestartNumber(String input) {
        if (input.equals(RESTART)) {
            return RESTART;
        }
        return END;
    }
}

