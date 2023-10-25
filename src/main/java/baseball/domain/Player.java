package baseball.domain;

import static baseball.constant.BaseballConstant.MAX_RANDOM_NUMBER;
import static baseball.constant.BaseballConstant.MIN_RANDOM_NUMBER;
import static baseball.constant.BaseballConstant.NUMBER_OF_TARGET;
import static baseball.constant.BaseballConstant.PLAYER_INPUT_MESSAGE;

import baseball.model.Score;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Integer> predictions = new ArrayList<>();
    private Score score;

    public Score getScore() {
        return score;
    }

    public Integer getPrediction(int index) {
        return predictions.get(index);
    }

    public void predict() {
        initPredictions();
        String numberString = readNumberString();
        parseNumberString(numberString);
    }

    private void initPredictions() {
        score = new Score();
        predictions.clear();
    }

    private String readNumberString() {
        System.out.print(PLAYER_INPUT_MESSAGE);
        return Console.readLine();
    }

    private void parseNumberString(String numberString) {
        if (numberString.length() != NUMBER_OF_TARGET) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < NUMBER_OF_TARGET; ++i) {
            char ch = numberString.charAt(i);
            int prediction = Character.getNumericValue(ch);
            if (MIN_RANDOM_NUMBER > prediction || MAX_RANDOM_NUMBER < prediction) {
                throw new IllegalArgumentException();
            }
            if (predictions.contains(prediction)) {
                throw new IllegalArgumentException();
            }
            predictions.add(prediction);
        }
    }
}
