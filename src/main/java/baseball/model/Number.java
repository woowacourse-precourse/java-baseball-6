package baseball.model;

import baseball.view.outputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Number {
    private ArrayList<Integer> number;

    public Number() {
        number = new ArrayList<>();
    }

    public void setNumber(ArrayList<Integer> number) {
        this.number = number;
    }

    public ArrayList<Integer> getNumber() {
        return number;
    }

    public void getComputerRandomNumber() {
        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
    }

    public boolean checkSuccess(ArrayList<Integer> inputNumber) {
        if (getStrikeCount(inputNumber) != 3) {
            return false;
        } else {
            outputView.displayExitMessage();
            return true;
        }
    }

    public int getStrikeCount(ArrayList<Integer> inputNumber) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (number.get(i).equals(inputNumber.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int getBallCount(ArrayList<Integer> inputNumber) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (number.contains(inputNumber.get(i)) && !number.get(i).equals(inputNumber.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    public boolean checkNothing(ArrayList<Integer> inputNumber) {
        return getStrikeCount(inputNumber) == 0 & getBallCount(inputNumber) == 0;
    }
}