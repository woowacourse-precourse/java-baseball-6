package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> number = new ArrayList<>();
    private String result;

    public List<Integer> getNumber() {
        return number;
    }

    public void setRandomNumber() {
        resetNumber();

        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
    }

    public void createResult(int ball, int strike) {
        StringBuilder result = new StringBuilder();

        if (ball == 0 && strike == 0) {
            result.append(Result.NOTHING_RESULT.getResult());
            String computerResult = result.toString();
            setResult(computerResult);
            return;
        }

        if (ball != 0) {
            result.append(ball).append(Result.BALL_RESULT.getResult());
        }

        if (ball != 0 && strike != 0) {
            result.append(" ").append(strike).append(Result.STRIKE_RESULT.getResult());
        }

        if (ball == 0 && strike != 0) {
            result.append(strike).append(Result.STRIKE_RESULT.getResult());
        }

        if (strike == 3) {
            result.append(Result.ALL_STRIKE_RESULT.getResult());
        }

        String computerResult = result.toString();
        setResult(computerResult);
    }

    private void setResult(String result) {
        this.result = result;
    }

    public void printResult() {
        System.out.println(result);
    }

    private void resetNumber() {
        number.clear();
    }


}
