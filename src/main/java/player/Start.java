package player;

import camp.nextstep.edu.missionutils.Console;
import computer.CompareTwoValues;
import computer.Error;
import computer.RandomPickNumber;
import constant.GuideMessageConstant;
import constant.StringConstant;

public class Start {
    String restarting_Game = StringConstant.CONTINUE;

    public Start() {
        while (StringConstant.CONTINUE.equals(restarting_Game)) {
            System.out.println(GuideMessageConstant.START_MESSAGE);
            RandomPickNumber.randomPickNumber();
            CompareTwoValues compareTwoValues = new CompareTwoValues();

            while (compareTwoValues.strikeCount != StringConstant.MAX_STRIKE) {
                Input.inputNumber();

                compareTwoValues.compareTwoValues(Integer.parseInt(Input.inputNumber));
            }

            System.out.println(GuideMessageConstant.END_MESSAGE);
            System.out.println(GuideMessageConstant.RESTART_END_MESSAGE);

            restarting_Game = Console.readLine();
            Error.restartCommandError(restarting_Game);

            RandomPickNumber.RandomPickClear();
        }
    }


}
