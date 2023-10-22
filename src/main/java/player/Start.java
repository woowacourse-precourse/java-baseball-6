package player;

import computer.CompareTwoValues;
import computer.RandomPickNumber;
import constant.GuideMessageConstant;

public class Start {

    public Start() {
        System.out.println(GuideMessageConstant.START_MESSAGE);
        RandomPickNumber.randomPickNumber();
        CompareTwoValues compareTwoValues = new CompareTwoValues();

        while (compareTwoValues.strikeCount != 3) {
            Input.inputNumber();

            compareTwoValues.compareTwoValues(Input.inputNumber);
        }

        System.out.println(GuideMessageConstant.END_MESSAGE);
    }


}
