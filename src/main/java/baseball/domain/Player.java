package baseball.domain;

import static baseball.constant.BaseballConstant.NUMBER_OF_TARGET;

import baseball.model.Score;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private Score score;
    private final List<Integer> predictions = new ArrayList<>();


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
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private void parseNumberString(String numberString) {
        if (numberString.length() != NUMBER_OF_TARGET) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < NUMBER_OF_TARGET; ++i) {
            char ch = numberString.charAt(i);
            if ('1' > ch || '9' < ch) {
                throw new IllegalArgumentException();
            }
            Integer prediction = Character.getNumericValue(ch);
            if (predictions.contains(prediction)) {
                throw new IllegalArgumentException();
            }
            predictions.add(prediction);
        }
    }
}
