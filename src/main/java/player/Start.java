package player;

import computer.RandomPickNumber;
import constant.GuideMessageConstant;

public class Start {

    public Start() {
        System.out.println(GuideMessageConstant.START_MESSAGE);
        RandomPickNumber.randomPickNumber();
        Input.inputNumber();
    }



}
