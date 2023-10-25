package baseball.model;

import static baseball.model.Constant.BASEBALL_NUM_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private String answerNumberString;

    public void createRandomNumber() {
        List<Integer> newNumber = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (newNumber.size() < BASEBALL_NUM_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!newNumber.contains(randomNumber)) {
                newNumber.add(randomNumber);
                stringBuilder.append(randomNumber);
            }
        }
        this.answerNumberString = stringBuilder.toString();
    }

    public String getResult(String userInput) {
        BaseballResult baseballResult = new BaseballResult(userInput, answerNumberString);
        return baseballResult.baseballGameResult();
    }

    public boolean getIsCorrect(String userInput) {
        BaseballResult baseballResult = new BaseballResult(userInput, answerNumberString);
        return baseballResult.getIsCorrect();
    }

}
