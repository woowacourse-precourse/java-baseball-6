package baseball.controller;

import baseball.model.DecimalNumber;
import baseball.model.NumberRule;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    private int NUM_SIZE = NumberRule.GAME_NUMBER_SIZE.getNumber();
    private int NUM_START = NumberRule.GAME_NUMBER_RANGE_START.getNumber();
    private int NUM_END = NumberRule.GAME_NUMBER_RANGE_END.getNumber();
    private Validation validation;
    private DecimalNumber decimalNumber;

    public RandomNumber(Validation validation, DecimalNumber decimalNumber) {
        this.validation = validation;
        this.decimalNumber = decimalNumber;
    }


    public void generateRandomNum() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < NUM_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(NUM_START, NUM_END);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        validation.validationGameNumber(computer);    //랜덤 숫자 생성 유효성 검사

    }
}
