package player;

import camp.nextstep.edu.missionutils.Console;
import constant.GuideMessageConstant;

public class Input {

    public static void inputNumber(){
        System.out.println(GuideMessageConstant.NUMBER_INPUT_MESSAGE);
        Console.readLine();
    }

}
